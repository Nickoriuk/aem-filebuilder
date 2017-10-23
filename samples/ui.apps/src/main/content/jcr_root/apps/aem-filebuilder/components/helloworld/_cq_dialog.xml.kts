package apps.aemrtepluginexample.components.content.title

import io.redcastle.aem.filebuilder.dsl.*
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts

dialog("Nested DSL Dialog", StandardLayouts.FIXED_COLUMNS) {
    textField("helloTarget", "./hello") {
        fieldLabel = "Hello Target"
        fieldDescription = "The person to say hello to. If not set, the value 'World' will be used."
        this.emptyText = "Eg. John or World"
    }
}
