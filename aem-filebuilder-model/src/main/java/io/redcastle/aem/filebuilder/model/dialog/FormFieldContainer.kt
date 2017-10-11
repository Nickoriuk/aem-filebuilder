package io.redcastle.aem.filebuilder.model.dialog

import io.redcastle.aem.filebuilder.model.api.Node

/**
 * A container which can hold form fields. Examples include dialogs, multi fields, containers, etc.
 * The type exposes a method for adding fields to the container.
 */
interface FormFieldContainer {
    /**
     * Adds the provided field to the container.
     * @param [field] The field to add to the container. A field is typically a [Node] which has a name and resource type defined.
     */
    fun addField(field: Node)
}
