package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter // genera todos los setter public por defecto (value = AccessLevel.PUBLIC)
@Setter // genera todos los getter public por defecto (value = AccessLevel.PUBLIC)
@AllArgsConstructor // genera el constr de todos los atributos public por defecto (access = AccessLevel.PUBLIC)
@NoArgsConstructor  // genera el constr sin ningun atributo public por defecto
@FieldDefaults(level = AccessLevel.PRIVATE) // asigna todos los atributos como privados(operador de acceso), acciona en todos los atributos excepto aquello que ya tiene el operador de acceso
//@FieldDefaults(makeFinal = true)    // esto brinda un error al constr vacio ya que el valor de los atributos no cambia(constante y no falta) el constr. vacio no respeta ello
@ToString(
//        exclude = {"username", "email"}  // podemos excluir datos necesarios, dependiendo del proyecto
//        includeFieldNames = false   // solo mostrara el valor de los atributos mas no los nombres de estos
//        of = {"username", "email"}  // permite mostrar solo los atributos que indicamos entre {}
//        callSuper = true    // llama a los atributos de la clase padre, relacionados, y los mostrar tambien, en caso herencia Inheritance
)
@EqualsAndHashCode(
//        exclude = {"password"}  // genera los metodos equalandhashcode sin el atributo 'password'
//        of = {"password", "email"}  // genera los metodos equalandhashcode solo con los atributos indicados
//        doNotUseGetters = true  // solo tomara los valores de los atributos sin los getter
)
//@Data // esta anotacion cubre Getter, Setter, ToString, EqualsAndHashCode, NoArgsConstructor, para obtener AllArgsConstructor debe ingresar la anotacion AllArgsConstructor y NoArgsConstructor
@Builder(   //nos genera otra clase, que se rige por el patron de diseño builder, permite formar objetos dinamicamente
//        builderMethodName = "create"    // podemos personalizar el nombre del metodo para crear objetos
//        builderClassName = "personConstructor"  // podemos personalizar el nombre de la clase builder
)
//@Value  // asigna clases y atributos inmutables(private final) y solo metodos getter
//@RequiredArgsConstructor // va de la mano con value, y obliga a enviar valores a los atributos final, y enviar paramtros a los atributos con anotacion @NonNull, genera un constructor con el atributo que tenga esta anotacion
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    Long ownerId;
    String username;
//    @NonNull
    String email;
    String password;

    @OneToMany(targetEntity = Pet.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pet> pets;

    @OneToMany(targetEntity = Community.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Community> communities;
}
