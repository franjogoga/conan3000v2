<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
                        <li><a class="ajax-link" href="<%=request.getContextPath()%>/IngSoft/general/index.jsp"><i class="icon-home"></i><span class="hidden-tablet"> Home</span></a></li>
   						
   						<a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.administracion').slideToggle(800)">Servicios</li> </a>
   						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/Club/servicio/sorteo/buscarInscripcionSorteo.jsp"><i class="icon-wrench"></i><span class="hidden-tablet"> Sorteos</span></a></li>
   						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=1"><i class="icon-wrench"></i><span class="hidden-tablet"> Eventos Socio</span></a></li>
   						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=3"><i class="icon-wrench"></i><span class="hidden-tablet"> Eventos Sede</span></a></li>	
   						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/Club/servicio/reserva/SMCReserva?accion=Buscar&tipo=1"><i class="icon-wrench"></i><span class="hidden-tablet"> Reservas</span></a></li>
   									   					
						<!-- <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/actividad/SMAActividad?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Actividades</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/ambiente/SMAAmbiente?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Ambientes</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/bungalow/SMABungalow?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Bungalows</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/cancha/SMACancha?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Canchas </span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/concesionario/SMAConcesionario?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Concesionarios </span></a></li>      
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/configuracion/configuracion.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Configuracion</span></a></li>   
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/empleados/buscarempleado.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Empleados</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Horario de Actividad</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/horariodetrabajo/buscarhorariodetrabajo.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Horario de Trabajos</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/invitado/buscarinvitado.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Invitados</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/reserva/buscarreserva.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reserva</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/jornada/buscarjornada.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Jornadas</span></a></li>   
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/jornada/marcarjornada.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Marcar Jornada </span></a></li>  
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/infraccion/buscarinfraccion.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Infraccion</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/perfiles/buscarperfil.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Perfiles</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/sede/SMASede?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Sedes</span></a></li>   
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/servicio/SMAServicio?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Servicios</span></a></li>      
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/socio/accionsocio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Socio</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/usuarios/buscarusuario.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Usuarios</span></a></li>
						<li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/invitados/visitaregistrar.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Visitas</span></a></li>
				

						<a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.servicio').slideToggle(800)">Servicios</li> </a>
						<li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/evento/SMSEvento?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Eventos</span></a></li>
						<li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/juridica/juridicabuscar.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Persona Juridica</span></a></li>
 						<li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/reporte/generarreportes.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reportes</span></a></li>
						<li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/reserva/SMSReserva?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reservas</span></a></li>
						<li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/sorteo/buscarsorteo.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Sorteos</span></a></li>
						
  						
						<a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.venta').slideToggle(800)">Ventas</li> </a>  					
						
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/administracion/cuotasmultas/cuotaagregar.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Cuotas</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/familia/buscarfamiliar.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Familiares</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/membresia/buscarmembresia.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Membresias</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/pago/buscarpago.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Pagos</span></a></li>                                                                    
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/producto/buscarproducto.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Productos</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/promociones/buscarpromocion.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Promociones</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/proveedor/buscarproveedor.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Proveedores</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/servicioproveedor/buscarservicio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Servicio de Proveedor </span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/socio/buscarsocio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Socios</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/solicitud/solicitud.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Solicitudes</span></a></li>
						<li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/ventaproducto/buscarventaproducto.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Venta de Productos</span></a></li>-->						
                        </ul>
				</div><!--/.well -->
			</div><!--/span-->