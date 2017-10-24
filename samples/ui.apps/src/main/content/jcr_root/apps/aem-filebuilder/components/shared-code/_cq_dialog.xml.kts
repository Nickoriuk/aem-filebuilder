package apps.aemfilebuilder.components.sharedcode

import io.redcastle.aem.filebuilder.dsl.*
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts
import io.redcastle.aem.filebuilder.samples.*

dialog("Message", StandardLayouts.FIXED_COLUMNS) {
    /*
     * theme() is declared in the dialogsupport maven module. It adds a dropdown which will be the same in each dialog.
     */
    theme()
}
