<%@page import="java.util.Vector"%>
<%@page import="IngSoft.general.bean.PerfilBeanData"%>
<jsp:useBean id="casosDeUso" scope="session" class="java.util.Vector"></jsp:useBean>

<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
                        <li><a class="ajax-link" href="<%=request.getContextPath()%>/IngSoft/general/index.jsp"><i class="icon-home"></i><span class="hidden-tablet"> Home</span></a></li>
   						<%  int i=0;
   							while (i<casosDeUso.size()){
   								String mant = ((PerfilBeanData)casosDeUso.get(i)).getMantenimiento();
   								if (mant.equals("ADMINISTRACION")){ 
   										%><a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.administracion').slideToggle(800)">Administracion</li> </a><%
   										while ( ((PerfilBeanData)casosDeUso.get(i)).getMantenimiento().equals("ADMINISTRACION") ){
	   										String casoUso = ((PerfilBeanData)casosDeUso.get(i)).getIdCasoUso();
	   										if (casoUso.equals("SMAActividad")) {%><li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/actividad/SMAActividad?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Actividades</span></a></li>
	   																   <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/actividad/SMAActividad?accion=BuscarMatricula&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Matricula Actividad</span></a></li><%
	   										}else if (casoUso.equals("SMAAmbiente")){%><li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/ambiente/SMAAmbiente?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Ambientes</span></a></li><%
	   										}else if (casoUso.equals("SMABungalow")){%><li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/bungalow/SMABungalow?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Bungalows</span></a></li><%
	   										}else if (casoUso.equals("SMACancha")){%><li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/cancha/SMACancha?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Canchas </span></a></li><%
	   										}else if (casoUso.equals("SMAConcesionario")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/concesionario/SMAConcesionario?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Concesionarios </span></a></li> <%
	   										}else if (casoUso.equals("SMAHorariodeactividad")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Horario de Actividad</span></a></li> <%
	   										}else if (casoUso.equals("SMAHorariodetrabajo")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/horariodetrabajo/buscarhorariodetrabajo.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Horario de Trabajos</span></a></li> <%
	   										}else if (casoUso.equals("SMAInvitado")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/invitado/buscarinvitado.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Invitados</span></a></li> <%
	   										}else if (casoUso.equals("SMAJornada")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/jornada/marcarjornada.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Jornadas</span></a></li> <%
	   										}else if (casoUso.equals("SMAPerfil")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/perfiles/buscarperfil.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Perfiles</span></a></li><%
	   										}else if (casoUso.equals("SMAReserva")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/reserva/buscarreserva.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reserva de Invitados</span></a></li><%
	   										}else if (casoUso.equals("SMASede")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/sede/SMASede?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Sedes</span></a></li> <%
	   										}else if (casoUso.equals("SMAServicio")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/servicio/SMAServicio?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Servicios</span></a></li> <%
	   										}else if (casoUso.equals("SMASocio")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/socio/accionsocio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Socio</span></a></li><%
	   										}else if (casoUso.equals("SMAConcesionario")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/concesionario/SMAConcesionario?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Concesionarios </span></a></li> <%
	   										}else if (casoUso.equals("SMAInfraccion")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/infraccion/buscarinfraccion.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Multas por Infraccion </span></a></li> <%
	   										}else if (casoUso.equals("SMAConfiguracion")){%> <li><a class="ajax-link administracion" href="<%=request.getContextPath()%>/IngSoft/administracion/SMAConfiguracion?accion=Consultar"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Multas por Infraccion </span></a></li> <%
	   										}
	   										i++;
	   										if (i==casosDeUso.size()) break;
	   									}
   									}
   									else if (mant.equals("SERVICIO")){ 
   										%><a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.servicio').slideToggle(800)">Servicios</li> </a><%
   										while ( ((PerfilBeanData)casosDeUso.get(i)).getMantenimiento().equals("SERVICIO") ){
	   										String casoUso = ((PerfilBeanData)casosDeUso.get(i)).getIdCasoUso();
	   										if (casoUso.equals("SMSEvento")) {%><li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/evento/SMSEvento?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Eventos</span></a></li><%
	   										}else if (casoUso.equals("SMSReporte")){%><li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/reporte/generarreportes.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reportes</span></a></li><%
	   										}else if (casoUso.equals("SMSReserva")){%><li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/reserva/SMSReserva?accion=Buscar&tipo=1"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reservas</span></a></li><%
	   										}else if (casoUso.equals("SMSSorteo")){%><li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/servicio/sorteo/buscarsorteo.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Sorteos</span></a></li><%
	   										}else if (casoUso.equals("SMSEmpleado")){%><li><a class="ajax-link servicio" href="<%=request.getContextPath()%>/IngSoft/administracion/empleados/buscarempleado.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Empleados</span></a></li><%
	   										}
	   										i++;
	   										if (i==casosDeUso.size()) break;
	   									}
   									}else if (mant.equals("VENTA")){ 
   										%><a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.venta').slideToggle(800)">Ventas</li> </a><%
   										while ( ((PerfilBeanData)casosDeUso.get(i)).getMantenimiento().equals("VENTA") ){
	   										String casoUso = ((PerfilBeanData)casosDeUso.get(i)).getIdCasoUso();
	   										if (casoUso.equals("SMVPromocion")){%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/promociones/buscarpromocion.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Promociones</span></a></li><%
	   										}else if (casoUso.equals("SMVMembresia")){%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/membresia/buscarmembresia.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Membresias</span></a></li><%
	   										}else if (casoUso.equals("SMVProveedor")){%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/proveedor/buscarproveedor.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Proveedores</span></a></li><%
	   										}else if (casoUso.equals("SMVPago")){%> <li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/pago/buscarpago.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Pagos</span></a></li> <%
	   										}else if (casoUso.equals("SMVServicio")){%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/servicioproveedor/buscarservicio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Servicio de Proveedor </span></a></li> <%
	   										}else if (casoUso.equals("SMVProducto")){%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/producto/buscarproducto.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Productos</span></a></li> <%
	   										}else if (casoUso.equals("SMVSocio")){%> <li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/socio/buscarsocio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Socios</span></a></li> <%
	   										}else if (casoUso.equals("SMVFamiliar")){%> <li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/familia/buscarfamiliar.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet">Familiares</span></a></li> <%
	   										}else if (casoUso.equals("SMVSolicitudSocio")){%> <li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/solicitud/buscarsolicitudsocio.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Solicitud de Socio</span></a></li> <%
	   										}else if (casoUso.equals("SMVJuridica")) {%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/servicio/juridica/juridicabuscar.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Persona Juridica</span></a></li><%	   										
	   										}else if (casoUso.equals("SMVSolicitudProducto")) {%><li><a class="ajax-link venta" href="<%=request.getContextPath()%>/IngSoft/ventas/solicitud/buscarsolicitudproducto.jsp"style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> solicitud producto</span></a></li><%	   										
	   										} 
	   										i++;
	   										if (i==casosDeUso.size()) break;
	   									}
   									}else if (mant.equals("SOCIO")){ 
   										%><a style="CURSOR: hand; text-decoration:none" href="#"> <li class="nav-header hidden-tablet" onclick="$('.socio').slideToggle(800)">Socios</li> </a><%
   										while ( ((PerfilBeanData)casosDeUso.get(i)).getMantenimiento().equals("SOCIO") ){
	   										String casoUso = ((PerfilBeanData)casosDeUso.get(i)).getIdCasoUso();
	   										if (casoUso.equals("SMCEvento")) {%><li><a class="ajax-link socio" href="<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=1" style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Eventos Socio</span></a></li>
   																				<li><a class="ajax-link socio" href="<%=request.getContextPath()%>/Club/servicio/evento/SMCEvento?accion=Buscar&tipo=3" style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Eventos Sede</span></a></li><%
	   										}else if (casoUso.equals("SMCReserva")){%><li><a class="ajax-link socio" href="<%=request.getContextPath()%>/Club/servicio/reserva/SMCReserva?accion=Buscar&tipo=1" style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Reservas</span></a></li><%
	   										}else if (casoUso.equals("SMCSorteo")){%><li><a class="ajax-link socio" href="<%=request.getContextPath()%>/Club/servicio/sorteo/buscarInscripcionSorteo.jsp" style="display:none"><i class="icon-wrench"></i><span class="hidden-tablet"> Sorteos</span></a></li><%
	   										}
	   										i++;
	   										if (i==casosDeUso.size()) break;
	   									}
	   								}else i++;    									   							
   							}
   							
   						 %>
   							
   						
						
						
 						
						
						
						
  						
						  					
						
											
                        </ul>
				</div><!--/.well -->
			</div><!--/span-->