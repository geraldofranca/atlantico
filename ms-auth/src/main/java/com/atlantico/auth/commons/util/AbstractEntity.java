package com.atlantico.auth.commons.util;

import java.lang.reflect.Field;
import java.util.Collection;

public abstract class AbstractEntity {

    private Long id;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Class<? extends AbstractEntity> concreteClass = getClass();
        builder.append(concreteClass.getSimpleName()).append("{");
        boolean isFirstField = true;
        for (Field field : concreteClass.getDeclaredFields()) {
            if (isFirstField) {
                isFirstField = false;
            } else {
                builder.append(", ");
            }
            builder.append(field.getName()).append("=");
            try {
                field.setAccessible(true);
                appendFieldValueToBuilder(field.get(this), builder);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                builder.append(e.getMessage());
            }
        }
        builder.append("}");
        return builder.toString();
    }

    private void appendFieldValueToBuilder(Object object, StringBuilder sb) {
        if (object instanceof AbstractEntity) {
            AbstractEntity entity = (AbstractEntity) object;
            String className = entity.getClass().getSimpleName();
            sb.append(className).append("{id=").append(entity.id).append("}");
        } else {
            if (object instanceof Collection) {
                Collection<?> collection = (Collection<?>) object;
                sb.append("[");
                boolean isFirstElement = true;
                for (Object o : collection) {
                    if (isFirstElement) {
                        isFirstElement = false;
                    } else {
                        sb.append(", ");
                    }
                    appendFieldValueToBuilder(o, sb);
                }
                sb.append("]");
            } else {
                sb.append(object);
            }
        }
    }
}
