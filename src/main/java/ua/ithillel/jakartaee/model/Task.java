package ua.ithillel.jakartaee.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    @XmlElement
    private String name;
    @XmlElement
    private boolean completed;
}
