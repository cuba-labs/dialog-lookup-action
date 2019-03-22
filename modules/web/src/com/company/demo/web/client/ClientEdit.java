package com.company.demo.web.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Client;

@UiController("demo_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
@LoadDataBeforeShow
public class ClientEdit extends StandardEditor<Client> {
}