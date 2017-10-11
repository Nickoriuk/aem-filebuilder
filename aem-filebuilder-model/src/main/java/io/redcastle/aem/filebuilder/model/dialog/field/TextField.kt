package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate

class TextField(nodeName: String, formName: String) : DialogField(nodeName, formName, RESOURCE_TYPE) {
    var fieldLabel: String? by propertyDelegate()
    var fieldDescription: String? by propertyDelegate()
    var value: String? by propertyDelegate()
    var emptyText: String? by propertyDelegate()
    var disabled: Boolean? by propertyDelegate()
    var required: Boolean? by propertyDelegate()
    var autocomplete: String? by propertyDelegate()
    var autofocus: Boolean? by propertyDelegate()
    var validation: List<String> by propertyDelegate()
    var maxlength: Long? by propertyDelegate()

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/textfield"
    }
}
