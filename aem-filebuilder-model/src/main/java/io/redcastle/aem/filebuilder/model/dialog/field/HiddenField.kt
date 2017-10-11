package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate

class HiddenField(nodeName: String, formName: String): DialogField(nodeName, formName, RESOURCE_TYPE) {
    var disabled: Boolean? by propertyDelegate()
    var value: String? by propertyDelegate()

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/hidden"
    }
}
