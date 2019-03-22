package com.company.demo.web.actions;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.DevelopmentException;
import com.haulmont.cuba.gui.ComponentsHelper;
import com.haulmont.cuba.gui.actions.picker.LookupAction;
import com.haulmont.cuba.gui.builders.LookupBuilder;
import com.haulmont.cuba.gui.components.ActionType;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.screen.LookupScreen;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.gui.screen.Screen;

@ActionType("dialog_lookup")
public class DialogLookupAction extends LookupAction {

    public DialogLookupAction() {
        super("dialog_lookup");
    }

    public DialogLookupAction(String id) {
        super(id);
    }

    @Override
    public void actionPerform(Component component) {
        // if standard behaviour
        if (!hasSubscriptions(ActionPerformedEvent.class)) {
            MetaClass metaClass = pickerField.getMetaClass();
            if (metaClass == null) {
                throw new DevelopmentException("Neither metaClass nor datasource/property is specified " +
                        "for the PickerField", "action ID", getId());
            }

            LookupBuilder lookupBuilder = screenBuilders.lookup(pickerField);
            Screen frameOwner = ComponentsHelper.getWindowNN(pickerField).getFrameOwner();

            // if called from Lookup - use DIALOG
            if (frameOwner instanceof LookupScreen
                    && ((LookupScreen) frameOwner).getSelectHandler() != null) {
                lookupBuilder.withOpenMode(OpenMode.DIALOG);
            }

            Screen lookupScreen = lookupBuilder
                    .build();
            lookupScreen.show();
        } else {
            // call action perform handlers from super, delegate execution
            super.actionPerform(component);
        }
    }
}