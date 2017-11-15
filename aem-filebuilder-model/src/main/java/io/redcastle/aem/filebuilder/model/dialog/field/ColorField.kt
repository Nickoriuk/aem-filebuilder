package io.redcastle.aem.filebuilder.model.dialog.field

import io.redcastle.aem.filebuilder.model.api.Node
import io.redcastle.aem.filebuilder.model.impl.NodeImpl
import io.redcastle.aem.filebuilder.model.items
import io.redcastle.aem.filebuilder.model.propertyDelegate

class ColorField(nodeName: String, formName: String) : DialogField(nodeName, formName, RESOURCE_TYPE) {

    var fieldLabel: String by propertyDelegate()
    var fieldDescription: String by propertyDelegate()
    var value: String? by propertyDelegate()
    var emptyText: String? by propertyDelegate()
    var disabled: Boolean? by propertyDelegate()
    var required: Boolean? by propertyDelegate()
    var variant: Variant? by propertyDelegate()
    var autogenerateColors: ColorGenerationStrategy? by propertyDelegate()
    var showSwatches: Boolean? by propertyDelegate()
    var showProperties: Boolean? by propertyDelegate()
    var showDefaultColors: Boolean? by propertyDelegate()
    var validation: List<String> by propertyDelegate()
    val options: MutableList<ColorFieldItem> get() = items().children as MutableList<ColorFieldItem>

    enum class Variant(private val jcrName: String) {
        DEFAULT("default"),
        SWATCH("swatch");

        override fun toString() = jcrName
    }

    enum class ColorGenerationStrategy(private val jcrName: String) {
        OFF("off"),
        SHADES("shades"),
        TINTS("tints");

        override fun toString() = jcrName
    }

    class ColorFieldItem(nodeName: String) : Node by NodeImpl(nodeName) {
        var value: String by propertyDelegate()
    }

    companion object {
        const val RESOURCE_TYPE = "granite/ui/components/coral/foundation/form/colorfield"
    }
}
