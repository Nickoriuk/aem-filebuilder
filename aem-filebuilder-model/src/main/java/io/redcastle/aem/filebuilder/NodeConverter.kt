package io.redcastle.aem.filebuilder

import io.redcastle.aem.filebuilder.model.api.Node
import java.util.function.Function

class NodeConverter : Function<Node, String> {
    override fun apply(t: Node): String {
        return convertNodeTreeToDocument(t).stringContents
    }
}
