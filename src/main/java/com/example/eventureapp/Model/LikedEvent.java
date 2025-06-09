package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "likedevent")
public class LikedEvent {

    @EmbeddedId
    private LikedEventKey id;

    public LikedEvent() {}

    public LikedEvent(Long studentId, Long eventId) {
        this.id = new LikedEventKey(studentId, eventId);
    }

    public LikedEventKey getId() {
        return id;
    }

    public void setId(LikedEventKey id) {
        this.id = id;
    }

    public Long getStudentId() {
        return id.getStudentId();
    }

    public Long getEventId() {
        return id.getEventId();
    }

    @Embeddable
    public static class LikedEventKey implements Serializable {

        @Column(name = "studentid")
        private Long studentId;

        @Column(name = "eventid")
        private Long eventId;

        public LikedEventKey() {}

        public LikedEventKey(Long studentId, Long eventId) {
            this.studentId = studentId;
            this.eventId = eventId;
        }

        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public Long getEventId() {
            return eventId;
        }

        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LikedEventKey)) return false;
            LikedEventKey that = (LikedEventKey) o;
            return Objects.equals(studentId, that.studentId) &&
                    Objects.equals(eventId, that.eventId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, eventId);
        }
    }
}
