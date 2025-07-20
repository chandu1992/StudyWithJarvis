package com.jarvisworkshop.StudyWithJarvis.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_screenshot")
public class Screenshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String imageUrl;


    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    public Screenshot() {
    }

    public Screenshot(String imageUrl, Note note) {
        this.imageUrl = imageUrl;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
