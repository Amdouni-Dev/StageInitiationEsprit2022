package com.server.server.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Avis_Key implements Serializable {

    @Column(name="id_client")
    private Integer id_Client;

    @Column(name="id_prod")
    private Integer id_Prod;
}
