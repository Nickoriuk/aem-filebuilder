package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.propertyDelegate

class FileUpload(nodeName: String, formName: String) : DialogField(nodeName, formName, RESOURCE_TYPE) {
    var emptyText: String? by propertyDelegate()
    var disabled: Boolean? by propertyDelegate()
    var async: Boolean? by propertyDelegate()
    var validation: List<String> by propertyDelegate()
    var multiple: Boolean? by propertyDelegate()
    var autoStart: Boolean? by propertyDelegate()
    var uploadUrl: String? by propertyDelegate()
    var sizeLimit: Long? by propertyDelegate()
    var mimeTypes: List<String> by propertyDelegate()
    var text: String? by propertyDelegate()
    var hideText: Boolean? by propertyDelegate()
    var icon: String? by propertyDelegate()
    var iconSize: String? by propertyDelegate()
    var size: String? by propertyDelegate()
    var variant: String? by propertyDelegate()

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/fileupload"
    }
}
