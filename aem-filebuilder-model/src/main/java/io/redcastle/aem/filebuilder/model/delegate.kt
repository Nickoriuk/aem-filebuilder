package io.redcastle.aem.filebuilder.model

import io.redcastle.aem.filebuilder.model.api.Node
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegate which offloads setting and getting of the property to the [Node]'s [attributes][Node.attributes])
 */
fun <T> propertyDelegate(customName: String? = null): ReadWriteProperty<Node, T> = NodePropertyDelegate(customName)

private class NodePropertyDelegate<T>(val customName: String? = null) : ReadWriteProperty<Node, T> {

    override operator fun setValue(thisRef: Node, property: KProperty<*>, value: T){
        thisRef.attributes[resolveNodePropertyName(property)] = value?.toString()
    }

    override operator fun getValue(thisRef: Node, property: KProperty<*>): T {
        return thisRef.attributes[resolveNodePropertyName(property)] as T
    }

    private fun resolveNodePropertyName(property: KProperty<*>): String = customName ?: property.name
}
