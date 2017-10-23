package apps.aemfilebuilder.components.referencetojava

import io.redcastle.aem.filebuilder.dsl.*
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import io.redcastle.aem.filebuilder.samples.MessageModel

dialog("Message", StandardLayouts.FIXED_COLUMNS) {
    /*
     * In this declaration, the form input name is coming from a constant defined in the backend.
     */
    textField("message", "./" + MessageModel.PROP_MESSAGE) {
        fieldLabel = "Message"
        fieldDescription = "The message to display to the user."
        required = true
    }
}
