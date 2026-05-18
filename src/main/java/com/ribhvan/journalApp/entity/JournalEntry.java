package com.ribhvan.journalApp.entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;

    @NotBlank
    private String title;

    private String content;

    private LocalDateTime date;
}
