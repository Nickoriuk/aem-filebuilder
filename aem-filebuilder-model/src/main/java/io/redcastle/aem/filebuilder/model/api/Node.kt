package io.redcastle.aem.filebuilder.model.api

import io.redcastle.aem.filebuilder.model.impl.VaultDsl

// TODO - consider a val parent: Node property. Can use this for same-sibling node name analysis.
@VaultDsl
interface Node {
    val name : String
    val children: MutableList<Node>
    val attributes: MutableMap<String, Any?>
}

