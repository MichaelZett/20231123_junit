package de.zettsystems.answer;

public interface MyRepository {
    Entity save(Entity newEntity, String id);
}
