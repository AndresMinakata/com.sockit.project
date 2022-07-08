
-- insertInto Usuarios
INSERT INTO `sockitdb`.`usuario` (`id`, `email`, `password`) VALUES ('1', 'kazuominakata@gmail.com', 'Pa$$w0rd');
INSERT INTO `sockitdb`.`usuario` (`id`, `email`, `password`) VALUES ('2', 'kazuominakata@hotmail.com', 'Pa$$w0rd');

-- insertInto Productos
INSERT INTO `sockitdb`.`producto` (`id`, `nombre`, `descripcion`, `url_imagen`, `precio`) VALUES ('1', 'Calcetines rojos', 'Calcetines de color rojo', 'calcetinesrojos.png', '80');
INSERT INTO `sockitdb`.`producto` (`id`, `nombre`, `descripcion`, `url_imagen`, `precio`) VALUES ('2', 'Calcetines azules', 'Calcetines de color azul', 'calcetinesazuless.png', '120');
INSERT INTO `sockitdb`.`producto` (`id`, `nombre`, `descripcion`, `url_imagen`, `precio`) VALUES ('3', 'Calcetines verdes', 'Calcetines de color verde', 'calcetinesverdes.png', '160');

-- insertInto Personalizar
INSERT INTO `sockitdb`.`personalizar` (`id`, `url_imagen_personalizar`) VALUES ('1', 'ch13.png');
INSERT INTO `sockitdb`.`personalizar` (`id`, `url_imagen_personalizar`) VALUES ('2', 'calcetinpersonalizado.png');
