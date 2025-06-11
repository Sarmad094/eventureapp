package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.EventDTO;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Model.Organization;
import com.example.eventureapp.Model.Field;
import com.example.eventureapp.Model.Location;

public class EventMapper {

    public static EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setEventId(event.getEventId());
        dto.setTitle(event.getTitle());
        dto.setE_description(event.getE_description());
        dto.setParticipants(event.getParticipants());
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());
        dto.setPrice(event.getPrice());

        // organizationId er Long, hent direkte med null-sjekk
        dto.setOrganizationId(event.getOrganization() != null ? event.getOrganization().getOrgId() : null);

        // fieldId er int i entitet, konverter til Long
        if (event.getFieldEntity() != null) {
            dto.setFieldId(Long.valueOf(event.getFieldEntity().getFieldId()));
        } else {
            dto.setFieldId(null);
        }

        // locationId er int i entitet, konverter til Long
        if (event.getLocation() != null) {
            dto.setLocationId(Long.valueOf(event.getLocation().getLocationId()));
        } else {
            dto.setLocationId(null);
        }

        return dto;
    }

    public static Event toEntity(EventDTO dto) {
        Event event = new Event();
        if (dto.getEventId() != null) {
            event.setEventId(dto.getEventId());
        }

        event.setTitle(dto.getTitle());
        event.setE_description(dto.getE_description());
        event.setParticipants(dto.getParticipants());
        event.setStartDate(dto.getStartDate());
        event.setEndDate(dto.getEndDate());
        event.setPrice(dto.getPrice());

        if (dto.getOrganizationId() != null) {
            Organization org = new Organization();
            org.setOrgId(dto.getOrganizationId());  // orgId er Long i Organization
            event.setOrganization(org);
        }

        if (dto.getFieldId() != null) {
            Field field = new Field();
            // Konverter Long til int (vær oppmerksom på verdiomfang)
            field.setFieldId(dto.getFieldId());
            event.setFieldEntity(field);
        }

        if (dto.getLocationId() != null) {
            Location loc = new Location();
            loc.setLocationId(dto.getLocationId().intValue());
            event.setLocation(loc);
        }

        return event;
    }
}
