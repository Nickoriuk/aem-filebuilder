package io.redcastle.aem.filebuilder.model.dialog

import io.redcastle.aem.filebuilder.model.api.Node

interface Layout {
    fun applyTo(node: Node)
    fun getLayoutRoot(node: Node): Node
    fun getItemRoot(node: Node): Node
}
