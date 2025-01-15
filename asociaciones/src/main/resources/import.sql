insert into autor (id, nombre)
values (nextval('autor_seq'), 'Autor 1');

insert into libros (descripcion, nombre, precio, id, autor_id)
values ('Descripción del Libro 3','Libro 3', 34.45, nextval('libros_seq'), currval('autor_seq'));