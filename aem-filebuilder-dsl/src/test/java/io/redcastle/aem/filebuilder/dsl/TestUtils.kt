package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.convertNodeTreeToDocument
import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.stringContents
import org.xmlunit.builder.DiffBuilder
import org.xmlunit.builder.Input
import org.xmlunit.diff.DefaultComparisonFormatter
import org.xmlunit.diff.DefaultNodeMatcher
import org.xmlunit.diff.Diff
import org.xmlunit.diff.ElementSelectors
import java.io.InputStream

/**
 * Takes the give node tree and converts it into an XML document for use with XMLUnit.
 */
internal fun DiffBuilder.withNodeTest(node: Node): DiffBuilder {
    return withTest(convertNodeTreeToDocument(node).stringContents)
}

internal fun getTestResource(resource: String): InputStream {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(resource)
}

internal fun getDifference(stream: InputStream, dialog: Node): Diff {
    return DiffBuilder.compare(Input.fromStream(stream))
            .withNodeMatcher(DefaultNodeMatcher(ElementSelectors.byName))
            .checkForSimilar()
            .withNodeTest(dialog).build()
}

internal fun xmlDiffFormatter(xmlDifference: Diff): () -> String {
    return {
        xmlDifference.differences.joinToString(separator = "\n") { it.toString(DefaultComparisonFormatter()) }
    }
}
