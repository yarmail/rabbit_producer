package com.example.rabbit_producer.domain;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Domain, Model, Entity
 */

@Getter
@Setter
public class User implements Serializable {
    private String userId;
    private String userName;
}

/*
Примечание
без Serializable возникает ошибка
InvalidDefinitionException: No serializer found for class ... and no properties
discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)

"Также необходимы геттеры и сеттеры, чтобы Jackson мог получить доступ
к состоянию объекта"

 */
