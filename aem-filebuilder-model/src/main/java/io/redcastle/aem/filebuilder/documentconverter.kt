package io.redcastle.aem.filebuilder

import io.redcastle.aem.filebuilder.model.api.Node
import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.StringWriter
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

// TODO - refactor attribute namespaces
fun convertNodeTreeToDocument(node: Node) : Document {
    val docFactory = DocumentBuilderFactory.newInstance()
    val docBuilder = docFactory.newDocumentBuilder()

    // root elements
    val document = docBuilder.newDocument()
    val root = nodeToElement(document, node, true)
    root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:sling", "http://sling.apache.org/jcr/sling/1.0")
    root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:cq", "http://www.day.com/jcr/cq/1.0")
    root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:jcr", "http://www.jcp.org/jcr/1.0")
    root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:nt", "http://www.jcp.org/jcr/nt/1.0")
    document.appendChild(root)
    return document
}

/**
 * Converts an implementation of Node to an Element, creating using the given document.
 */
private fun nodeToElement(doc: Document, node: Node, isRootElement: Boolean = false): Element {
    val element = try {
        doc.createElement(if (isRootElement) "jcr:root" else node.name)
    } catch (e: Exception){
        throw ConversionException("Attempted to create an XML element named '${node.name}' but got an error. Make sure it has a valid XML element name.", e)
    }

    for ((key, value) in node.attributes) {
        if (value != null) {
            try {
                element.setAttribute(key, value.toString())
            } catch (e: Exception) {
                throw ConversionException("Could not set attribute '$key' to '$value' on '${node.name}'. Make the sure XML name of the attribute is valid.", e)
            }
        }
    }

    node.children.forEach {
        val el : Element = nodeToElement(doc, it)
        element.appendChild(el)
    }

    return element
}

val Document.stringContents: String get() {
    val transformer = TransformerFactory.newInstance().newTransformer()
    transformer.setOutputProperty(OutputKeys.INDENT, "yes")
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4")
    val streamResult = StreamResult(StringWriter())
    val source = DOMSource(this)
    transformer.transform(source, streamResult)
    return streamResult.writer.toString()
}

class ConversionException(message: String?, cause: Throwable?) : Exception(message, cause)
