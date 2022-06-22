package com.server.server.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@Entity // to create a table in database using thi sclass

public class Avis implements Serializable {

    @EmbeddedId
    private Avis_Key id_note;

    private String commentaire;
    private Timestamp dateCreation;
    private float note;




}
