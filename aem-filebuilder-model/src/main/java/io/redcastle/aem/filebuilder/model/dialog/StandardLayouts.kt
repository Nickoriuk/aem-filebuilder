package io.redcastle.aem.filebuilder.model.dialog

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.impl.NodeImpl
import io.redcastle.aem.filebuilder.model.impl.nodeWithResourceType

enum class StandardLayouts : Layout {

    NAV_TABS {
        override fun getLayoutRoot(node: Node): Node {
            return node.childNamed("layout")
        }

        override fun getItemRoot(node: Node): Node {
            return node.childNamed("items")
        }

        override fun applyTo(node: Node) {
            node.apply {
                children.add(nodeWithResourceType("layout", "granite/ui/components/foundation/layouts/tabs") {
                    attributes["type"] = "nav"
                })
                children.add(NodeImpl("items"))
            }
        }
    },

    FIXED_COLUMNS {
        override fun getLayoutRoot(node: Node): Node {
            return node.childNamed("layout")
        }

        override fun getItemRoot(node: Node): Node {
            return node.childNamed("items")
                    .childNamed("column")
                    .childNamed("items")
        }

        override fun applyTo(node: Node) {
            node.apply {
                val element = NodeImpl("items")
                val column = nodeWithResourceType("column", "granite/ui/components/foundation/container") {
                    children.add(NodeImpl("items"))
                }
                element.children.add(column)
                children.add(element)
                children.add(nodeWithResourceType("layout", "granite/ui/components/foundation/layouts/fixedcolumns"))
            }


        }
    };

    protected fun Node.childNamed(name: String) = children.first { it.name == name }
}
