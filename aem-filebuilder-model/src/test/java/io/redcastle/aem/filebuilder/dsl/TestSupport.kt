package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.convertNodeTreeToDocument
import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.stringContents
import org.xmlunit.builder.DiffBuilder
import java.io.InputStream

// .stringContents required as in memory documents seem to have null data. Serializing fixes the issue
fun DiffBuilder.withNodeTest(node: Node) = withTest(convertNodeTreeToDocument(node).stringContents)

fun loadTestFile(path: String): InputStream? = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
