-- Eliminar la tabla usuario_rol si existe
DROP TABLE IF EXISTS usuario_rol;

-- Eliminar la tabla usuario si existe
DROP TABLE IF EXISTS usuario;

DROP TABLE IF EXISTS personaje;

-- Eliminar la tabla rol si existe
DROP TABLE IF EXISTS rol;

String saber= 'src\main\resources\Image\Saber.jpg';
String archer= 'src\main\resources\Image\Archer.jpg';
String lancer= 'src\main\resources\Image\lancer.jpg';

-- Crear la tabla usuario
CREATE TABLE usuario (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombreUsuario TEXT UNIQUE NOT NULL,
    nombre TEXT NOT NULL,
    contrasenia TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL 
);

-- Crear la tabla rol
CREATE TABLE rol (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL
);

-- Crear la tabla intermedia usuario_rol para la relación muchos a muchos
CREATE TABLE usuario_rol (
    usuario_id INTEGER,
    rol_id INTEGER,
    PRIMARY KEY (usuario_id, rol_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (rol_id) REFERENCES rol(id) ON DELETE CASCADE
);

-- Crear la tabla personaje
CREATE TABLE personaje (
    personaje_id INTEGER PRIMARY KEY AUTOINCREMENT,
    personajeNombre TEXT UNIQUE NOT NULL,
    personajeInfo TEXT UNIQUE NOT NULL,
    personajeFoto IMAGE UNIQUE,
)

INSERT INTO personaje (personajeNombre, personajeInfo, personajeFoto) VALUES
    ('Saber/Artoria Pendragon', 'Es uno de los personajes principales de la franquicia Fate, especialmente en Fate/stay night.
    Basada en la leyenda del Rey Arturo, en el universo de Fate Artoria es una mujer que vivió como el Rey de Bretaña,
    ocultando su identidad femenina para gobernar con justicia y fuerza.', saber),
    ('Archer/EMIYA', 'EMIYA, también conocido como Archer, es un Servant en Fate/stay night que representa una versión futura de Shirou Emiya,
    el protagonista de la historia. A diferencia de otros héroes, EMIYA no proviene de una leyenda antigua, sino de un posible futuro donde Shirou,
    tras años de luchar por la justicia, se convierte en un "héroe de la justicia" que termina desilusionado por no poder salvar a todos.', archer),
    ('Lancer/Cu Chulainn', 'Cú Chulainn, conocido como Lancer en Fate/stay night,
    es un Servant basado en el legendario héroe irlandés del mismo nombre. Es un guerrero ágil, valiente y con un fuerte sentido del honor en combate.
    Aunque puede parecer despreocupado y sarcástico, es leal y lucha con determinación.', lancer);

-- Insertar roles en la tabla rol
INSERT INTO rol (nombre) VALUES
    ('Administrador'),
    ('Editor'),
    ('Usuario');

-- Insertar usuarios de ejemplo
INSERT INTO usuario (nombreUsuario, nombre, contrasenia, email) VALUES
    ('Jpe', 'Juan Pérez', 'pass123', 'juan@example.com'),
    ('Anita', 'Ana López', 'securePass', 'ana@example.com'),
    ('Carlix', 'Carlos Gómez', 'claveSegura', 'carlos@example.com');

-- Asignar roles a los usuarios (ejemplo)
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES
    (1, 1), -- Juan Pérez es Administrador
    (2, 2), -- Ana López es Editor
    (3, 3), -- Carlos Gómez es Usuario
    (2, 3); -- Ana López también es Usuario
