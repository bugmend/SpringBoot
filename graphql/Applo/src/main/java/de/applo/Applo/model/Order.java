package de.applo.Applo.model;

import java.time.OffsetDateTime;

public record Order(Integer orderId, Book book, User user, OffsetDateTime orderedOn) {
}
