package com.company.demo.web.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Client;

@UiController("demo_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {
}