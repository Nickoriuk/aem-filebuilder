package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.model.dialog.Dialog
import io.redcastle.aem.filebuilder.model.dialog.FormFieldContainer
import io.redcastle.aem.filebuilder.model.dialog.Layout
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import io.redcastle.aem.filebuilder.model.dialog.field.Checkbox
import io.redcastle.aem.filebuilder.model.dialog.field.FieldSet
import io.redcastle.aem.filebuilder.model.dialog.field.Section
import io.redcastle.aem.filebuilder.model.dialog.field.TextField

inline fun FormFieldContainer.textField(nodeName: String, formName: String, init: TextField.() -> Unit) {
    val textField = TextField(nodeName, formName)
    textField.init()
    addField(textField)
}

inline fun FormFieldContainer.fieldset(nodeName: String, init: FieldSet.() -> Unit) {
    val field = FieldSet(nodeName).also(init)
    addField(field)
}

inline fun FormFieldContainer.checkbox(nodeName: String, fieldName: String, init: Checkbox.() -> Unit) {
    val node = Checkbox(nodeName, fieldName)
    node.init()
    addField(node)
}

inline fun FormFieldContainer.section(nodeName: String, init: Section.() -> Unit) {
    val field = Section(nodeName).also(init)
    addField(field)
}

inline fun dialog(title: String, layout: Layout = StandardLayouts.NAV_TABS, init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(title, layout)
    dialog.init()
    return dialog
}
