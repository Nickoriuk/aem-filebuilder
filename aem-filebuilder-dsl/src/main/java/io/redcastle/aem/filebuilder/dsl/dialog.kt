package io.redcastle.aem.filebuilder.dsl

import io.redcastle.aem.filebuilder.model.dialog.Dialog
import io.redcastle.aem.filebuilder.model.dialog.FormFieldContainer
import io.redcastle.aem.filebuilder.model.dialog.Layout
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import io.redcastle.aem.filebuilder.model.dialog.field.*


/**
 * Creates a new Dialog, using the Coral UI components in AEM 6.3. This is the main entry point into `aem-filebuilder-dsl`.
 *
 * @param [title] The title of the dialog, which is displayed at the top.
 * @param [layout] The layout of the dialog. Default implementations can be found in [StandardLayouts], which as of
 * writing includes a tabbed navigation layout ([StandardLayouts.NAV_TABS]) and a single column layout ([StandardLayouts.FIXED_COLUMNS]).
 * @param [init] an initialization function to set up further customizations of the dialog.
 * @return a dialog with the provided title and layout, and the customizations in [the initialization function][init] applied.
 */
inline fun dialog(title: String, layout: Layout = StandardLayouts.NAV_TABS, init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(title, layout)
    dialog.init()
    return dialog
}

/**
 * Adds a text field to the container.
 * @param [nodeName] the name of the text field node as stored in the JCR.
 * @param [formName] the name of the property which the field will store it's value in.
 * @param [init] lambda with receiver that can be used to initialize the TextField created by this function.
 */
inline fun FormFieldContainer.textField(nodeName: String, formName: String, init: TextField.() -> Unit) {
    val textField = TextField(nodeName, formName)
    textField.init()
    addField(textField)
}

/**
 * Generates a FieldSet, which can be used to logically organize related fields.
 * @param [nodeName] The name of the generated JCR node
 * @param [init] function to initialize the field set.
 */
inline fun FormFieldContainer.fieldset(nodeName: String, init: FieldSet.() -> Unit) {
    val field = FieldSet(nodeName).also(init)
    addField(field)
}

/**
 * Generates a checkbox and adds it to the container.
 * @param [nodeName] The name of the generated JCR node
 * @param [fieldName] the name of the property to store the form value in
 * @param [init] function to initialize the field set.
 */
inline fun FormFieldContainer.checkbox(nodeName: String, fieldName: String, init: Checkbox.() -> Unit) {
    val node = Checkbox(nodeName, fieldName)
    node.init()
    addField(node)
}

/**
 * Creates a new section. When used at the top level of a dialog in the [StandardLayouts.NAV_TABS] layout, it creates
 * a tab.
 *
 * @param [nodeName] the name of the section node in the JCR
 * @param [init] function to initialize the section
 */
inline fun FormFieldContainer.section(nodeName: String, init: Section.() -> Unit) {
    val field = Section(nodeName).also(init)
    addField(field)
}

/**
 * Creates a new multifield and adds it to the form field container. A multifield is also a FormFieldContainer, and
 * as a result can contain other fields.
 *
 * @param [nodeName] the name of the multifield root node in the JCR
 * @param [fieldName] the name of the form property name in the JCR
 * @param [init] function to initialize the multifield
 */
inline fun FormFieldContainer.multifield(nodeName: String, fieldName: String, init: Multifield.() -> Unit) {
    val node = Multifield(nodeName, fieldName)
    node.init()
    addField(node)
}

/**
 * Creates a new select, and adds it to the container after initialization.
 *
 * @param [nodeName] the name of the select node in the JCR
 * @param [init] function to initialize the select
 */
inline fun FormFieldContainer.select(nodeName: String, fieldName: String, init: Select.() -> Unit) {
    val node = Select(nodeName, fieldName)
    node.init()
    addField(node)
}

/**
 * Defines a static option on a select (drop down).
 * @param [nodeName] The name of the option in the JCR - this must be unique among all the available options.
 * @param [init] an initialization function
 */
inline fun Select.option(nodeName: String, init: Select.SelectItem.() -> Unit) {
    val node = Select.SelectItem(nodeName)
    node.init()
    options.add(node)
}
