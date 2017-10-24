package apps.aemfilebuilder.components.multifield

import io.redcastle.aem.filebuilder.dsl.*
import io.redcastle.aem.filebuilder.model.dialog.StandardLayouts

dialog("DSL - Multifield Example", StandardLayouts.NAV_TABS) {
    /*
     * Create a tab on the dialog called Links
     */
    section("links") {

        title = "Links"

        /*
         * Add a multifield to the tab
         */
        multifield("multifield", "./multifieldExample") {

            fieldLabel = "Links"

            /*
             * Set the multifield as composite (stored as nested node structure)
             */
            composite = true

            textField("href", "./href") {
                fieldLabel = "Link Location"
                required = true
            }

            textField("title", "./jcr:title") {
                fieldLabel = "Title"
                required = true
            }
        }
    }
}
