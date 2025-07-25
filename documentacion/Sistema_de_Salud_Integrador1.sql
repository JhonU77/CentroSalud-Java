USE [Sistema_ReporteClinico]
GO
/****** Object:  Table [dbo].[Atencion]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Atencion](
	[ID_Atencion] [int] NOT NULL,
	[Desc_Atencion] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Atencion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita](
	[ID_Cita] [int] IDENTITY(1,1) NOT NULL,
	[FechaRegistro_Cita] [date] NOT NULL,
	[FechaAtencion_Cita] [date] NOT NULL,
	[HoraAtencion_Cita] [time](7) NOT NULL,
	[ID_Establecimiento] [int] NOT NULL,
	[DNI_Paciente] [char](8) NOT NULL,
	[DNI_Personal] [char](8) NULL,
	[ID_Atencion] [int] NOT NULL,
	[ID_Usuario] [int] NOT NULL,
	[Estado_Cita] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Cita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Colegio]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Colegio](
	[ID_Colegio] [int] NOT NULL,
	[Desc_Colegio] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Colegio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Establecimiento]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Establecimiento](
	[ID_Establecimiento] [int] NOT NULL,
	[Nombre_Establecimiento] [varchar](100) NULL,
	[Red] [varchar](50) NULL,
	[Microred] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Establecimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Historial]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Historial](
	[ID_Historial] [int] IDENTITY(1,1) NOT NULL,
	[FechaRegistro_Historial] [date] NOT NULL,
	[Diagnostico] [varchar](300) NULL,
	[ID_Cita] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Historial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MetaExamen]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MetaExamen](
	[ID_MetaExamen] [int] IDENTITY(1,1) NOT NULL,
	[Cantidad_MetaExamen] [int] NULL,
	[FechaInicio_MetaExamen] [date] NULL,
	[FechaFin_MetaExamen] [date] NULL,
	[DNI_Personal] [char](8) NULL,
	[ID_Atencion] [int] NULL,
	[ID_Establecimiento] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_MetaExamen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paciente]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paciente](
	[DNI_Paciente] [char](8) NOT NULL,
	[Nombres_Paciente] [varchar](100) NULL,
	[ApellidoPaterno_Paciente] [varchar](100) NULL,
	[ApellidoMaterno_Paciente] [varchar](100) NULL,
	[FechaNacimiento_Paciente] [date] NULL,
	[Genero_Paciente] [char](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[DNI_Paciente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Personal]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Personal](
	[DNI_Personal] [char](8) NOT NULL,
	[Nombres_Personal] [varchar](100) NULL,
	[ApellidoPaterno_Personal] [varchar](100) NULL,
	[ApellidoMaterno_Personal] [varchar](100) NULL,
	[FechaNacimiento_Personal] [date] NULL,
	[Genero_Personal] [char](1) NULL,
	[Codigo_Colegiatura] [int] NULL,
	[ID_Colegio] [int] NULL,
	[ID_Profesion] [int] NULL,
	[ID_Establecimiento] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DNI_Personal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Profesion]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profesion](
	[ID_Profesion] [int] NOT NULL,
	[Desc_Profesion] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Profesion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReporteClinico]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReporteClinico](
	[ID_ReporteClinico] [int] IDENTITY(1,1) NOT NULL,
	[Nombre_ReporteClinico] [varchar](200) NULL,
	[FechaRegistro_ReporteClinico] [date] NULL,
	[HoraRegistro_ReporteClinico] [time](7) NULL,
	[FechaInicio_ReporteClinico] [date] NULL,
	[FechaFin_ReporteClinico] [date] NULL,
	[Edad_Desde] [int] NULL,
	[Edad_Hasta] [int] NULL,
	[Cantidad_Examen] [int] NULL,
	[DNI_Personal] [char](8) NULL,
	[ID_Atencion] [int] NULL,
	[ID_Establecimiento] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_ReporteClinico] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 20/07/2025 11:46:15 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[ID_Usuario] [int] IDENTITY(1,1) NOT NULL,
	[Correo] [varchar](100) NULL,
	[Contraseña] [varchar](100) NULL,
	[Rol] [varchar](50) NULL,
	[DNI_Personal] [char](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Atencion] ([ID_Atencion], [Desc_Atencion]) VALUES (1, N'PAP')
INSERT [dbo].[Atencion] ([ID_Atencion], [Desc_Atencion]) VALUES (2, N'IVA')
INSERT [dbo].[Atencion] ([ID_Atencion], [Desc_Atencion]) VALUES (3, N'VPH')
INSERT [dbo].[Atencion] ([ID_Atencion], [Desc_Atencion]) VALUES (4, N'CONSEJERIA')
INSERT [dbo].[Atencion] ([ID_Atencion], [Desc_Atencion]) VALUES (5, N'EXAMEN DE MAMAS')
GO
SET IDENTITY_INSERT [dbo].[Cita] ON 

INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (1, CAST(N'2025-06-26' AS Date), CAST(N'2025-06-28' AS Date), CAST(N'15:00:00' AS Time), 10001, N'73080624', N'71314318', 4, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (2, CAST(N'2025-06-30' AS Date), CAST(N'2025-07-01' AS Date), CAST(N'13:00:00' AS Time), 10001, N'12345678', N'41336364', 4, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (3, CAST(N'2025-07-01' AS Date), CAST(N'2025-07-01' AS Date), CAST(N'01:30:00' AS Time), 10001, N'12345678', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (5, CAST(N'2025-07-03' AS Date), CAST(N'2025-07-04' AS Date), CAST(N'13:00:00' AS Time), 10010, N'12345678', N'71314318', 3, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (6, CAST(N'2025-07-03' AS Date), CAST(N'2025-07-17' AS Date), CAST(N'08:00:00' AS Time), 10001, N'87654321', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (7, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-05' AS Date), CAST(N'03:00:00' AS Time), 10001, N'87654321', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (8, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-04' AS Date), CAST(N'08:30:00' AS Time), 10008, N'87654321', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (10, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-04' AS Date), CAST(N'05:30:00' AS Time), 10001, N'98765432', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (11, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-04' AS Date), CAST(N'06:30:00' AS Time), 10001, N'98765432', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (12, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-04' AS Date), CAST(N'06:30:00' AS Time), 10001, N'98765432', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (13, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'09:00:00' AS Time), 10003, N'72838072', NULL, 1, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (14, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'09:30:00' AS Time), 10003, N'72838072', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (15, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'10:00:00' AS Time), 10003, N'72838072', NULL, 3, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (16, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'10:30:00' AS Time), 10003, N'72838072', NULL, 4, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (17, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'11:00:00' AS Time), 10003, N'72838072', NULL, 5, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (18, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'12:00:00' AS Time), 10003, N'74353945', NULL, 1, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (19, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'12:30:00' AS Time), 10003, N'74353945', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (20, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'12:30:00' AS Time), 10003, N'74353945', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (21, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'13:00:00' AS Time), 10003, N'74353945', NULL, 3, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (22, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'01:00:00' AS Time), 10001, N'73394230', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (24, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'01:30:00' AS Time), 10003, N'73945392', NULL, 2, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (25, CAST(N'2025-07-11' AS Date), CAST(N'2025-07-11' AS Date), CAST(N'02:00:00' AS Time), 10003, N'73394230', NULL, 2, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (26, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'06:00:00' AS Time), 10001, N'87654321', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (27, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'06:00:00' AS Time), 10003, N'87654321', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (28, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-19' AS Date), CAST(N'06:00:00' AS Time), 10003, N'87654321', NULL, 1, 2, N'Pendiente')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (29, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'13:00:00' AS Time), 10003, N'87654321', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (30, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-17' AS Date), CAST(N'18:00:00' AS Time), 10003, N'87654321', NULL, 1, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (31, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-17' AS Date), CAST(N'18:00:00' AS Time), 10001, N'87654321', NULL, 3, 2, N'Vencido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (32, CAST(N'2025-07-18' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'13:30:00' AS Time), 10003, N'88888888', N'41336364', 1, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (36, CAST(N'2025-07-18' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'14:00:00' AS Time), 10003, N'11111111', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (37, CAST(N'2025-07-18' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'14:30:00' AS Time), 10003, N'77777777', N'41336364', 2, 2, N'Atendido')
INSERT [dbo].[Cita] ([ID_Cita], [FechaRegistro_Cita], [FechaAtencion_Cita], [HoraAtencion_Cita], [ID_Establecimiento], [DNI_Paciente], [DNI_Personal], [ID_Atencion], [ID_Usuario], [Estado_Cita]) VALUES (38, CAST(N'2025-07-18' AS Date), CAST(N'2025-07-18' AS Date), CAST(N'15:00:00' AS Time), 10003, N'88888888', N'41336364', 2, 2, N'Atendido')
SET IDENTITY_INSERT [dbo].[Cita] OFF
GO
INSERT [dbo].[Colegio] ([ID_Colegio], [Desc_Colegio]) VALUES (1, N'Colegio de Enfermeros del Perú')
INSERT [dbo].[Colegio] ([ID_Colegio], [Desc_Colegio]) VALUES (2, N'Colegio Médico del Perú')
INSERT [dbo].[Colegio] ([ID_Colegio], [Desc_Colegio]) VALUES (3, N'Colegio de Obstetras del Perú')
INSERT [dbo].[Colegio] ([ID_Colegio], [Desc_Colegio]) VALUES (4, N'Colegio de Psicologos del Perú')
INSERT [dbo].[Colegio] ([ID_Colegio], [Desc_Colegio]) VALUES (5, N'Colegio de Ingenieros del Perú')
GO
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10001, N'Hospital Regional Docente Las Mercedes', N'Lambayeque', N'Chiclayo')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10002, N'Hospital Regional Lambayeque', N'Lambayeque', N'Chiclayo')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10003, N'Centro de Salud José Leonardo Ortiz', N'Lambayeque', N'José Leonardo Ortiz')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10004, N'Centro de Salud Atusparia', N'Lambayeque', N'Atusparia')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10005, N'Posta de Salud La Victoria', N'Lambayeque', N'La Victoria')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10006, N'Centro de Salud Pueblo Nuevo', N'Ferreñafe', N'Pueblo Nuevo')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10007, N'Posta de Salud Incahuasi', N'Ferreñafe', N'Incahuasi')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10008, N'Centro de Salud Motupe', N'Chiclayo', N'Motupe')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10009, N'Centro de Salud Pimentel', N'Chiclayo', N'Pimentel')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10010, N'Posta de Salud Chongoyape', N'Chiclayo', N'Chongoyape')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10011, N'Centro de Salud Ferreñafe', N'Ferreñafe', N'Ferreñafe')
INSERT [dbo].[Establecimiento] ([ID_Establecimiento], [Nombre_Establecimiento], [Red], [Microred]) VALUES (10012, N'Centro de Salud Monsefú', N'Chiclayo', N'Monsefú')
GO
SET IDENTITY_INSERT [dbo].[Historial] ON 

INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (1, CAST(N'2025-07-01' AS Date), N'El paciente paso por consejeria y fue atendido como corresponde', 1)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (2, CAST(N'2025-07-01' AS Date), N'Paciente Aconsejado correctamente', 2)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (3, CAST(N'2025-07-01' AS Date), N'Pap echo exitosamente.
Resultados: Negativo', 3)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (4, CAST(N'2025-07-03' AS Date), N'El paciente da como resultado negativo ante examen de vph', 5)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (5, CAST(N'2025-07-03' AS Date), N'Examen PAP realizado con exito. Resultados: Negativo', 6)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (6, CAST(N'2025-07-04' AS Date), N'resultados: negativo', 7)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (7, CAST(N'2025-07-04' AS Date), N'Resultados: Negativo', 8)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (8, CAST(N'2025-07-04' AS Date), N'examen resalizado con exito', 11)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (9, CAST(N'2025-07-11' AS Date), N'Resalutados: Negativo', 14)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (10, CAST(N'2025-07-11' AS Date), N'Resultados: Negativo', 10)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (11, CAST(N'2025-07-11' AS Date), N'Resultados: Negativo', 12)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (12, CAST(N'2025-07-11' AS Date), N'Resultados: Negativo', 20)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (13, CAST(N'2025-07-11' AS Date), N'Resultados: Positivo', 22)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (14, CAST(N'2025-07-11' AS Date), N'Resultados:Negativo', 19)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (15, CAST(N'2025-07-18' AS Date), N'positivo', 27)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (16, CAST(N'2025-07-18' AS Date), N'positivo', 29)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (17, CAST(N'2025-07-18' AS Date), N'registrado', 26)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (18, CAST(N'2025-07-18' AS Date), N'si', 32)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (19, CAST(N'2025-07-18' AS Date), N'Resultados:Negativo', 38)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (20, CAST(N'2025-07-18' AS Date), N'negativo', 36)
INSERT [dbo].[Historial] ([ID_Historial], [FechaRegistro_Historial], [Diagnostico], [ID_Cita]) VALUES (21, CAST(N'2025-07-18' AS Date), N'negativo', 37)
SET IDENTITY_INSERT [dbo].[Historial] OFF
GO
SET IDENTITY_INSERT [dbo].[MetaExamen] ON 

INSERT [dbo].[MetaExamen] ([ID_MetaExamen], [Cantidad_MetaExamen], [FechaInicio_MetaExamen], [FechaFin_MetaExamen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (4, 6, CAST(N'2025-07-05' AS Date), CAST(N'2025-07-06' AS Date), N'72308372', 1, 10002)
INSERT [dbo].[MetaExamen] ([ID_MetaExamen], [Cantidad_MetaExamen], [FechaInicio_MetaExamen], [FechaFin_MetaExamen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (5, 2, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-11' AS Date), N'41336364', 1, 10002)
INSERT [dbo].[MetaExamen] ([ID_MetaExamen], [Cantidad_MetaExamen], [FechaInicio_MetaExamen], [FechaFin_MetaExamen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (6, 2, CAST(N'2025-07-04' AS Date), CAST(N'2025-07-07' AS Date), N'41336364', 2, 10002)
INSERT [dbo].[MetaExamen] ([ID_MetaExamen], [Cantidad_MetaExamen], [FechaInicio_MetaExamen], [FechaFin_MetaExamen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (8, 3, CAST(N'2025-07-01' AS Date), CAST(N'2025-07-12' AS Date), N'41336364', 2, 10003)
INSERT [dbo].[MetaExamen] ([ID_MetaExamen], [Cantidad_MetaExamen], [FechaInicio_MetaExamen], [FechaFin_MetaExamen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (10, 3, CAST(N'2025-07-17' AS Date), CAST(N'2025-07-19' AS Date), N'41336364', 2, 10003)
SET IDENTITY_INSERT [dbo].[MetaExamen] OFF
GO
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'11111111', N'Tania', N'Litano', N'Bustamante', CAST(N'2000-07-02' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'12345678', N'Oso', N'Campos', N'Diaz', CAST(N'2000-01-20' AS Date), N'M')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'72838072', N'Diana', N'Litano', N'Bustamante', CAST(N'2004-06-10' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'73080624', N'Stefano', N'Santisteban', N'Coico', CAST(N'2004-04-14' AS Date), N'M')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'73394230', N'Fabiola', N'Farro', N'Flores', CAST(N'1982-03-17' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'73945392', N'Katy', N'Farro', N'Flores', CAST(N'1982-03-24' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'74353945', N'Lilia', N'Torres', N'Ayasta', CAST(N'1980-07-10' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'77777777', N'Maria', N'Farro', N'Flores', CAST(N'2000-07-01' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'87654321', N'Juan', N'vazques', N'run', CAST(N'2000-07-20' AS Date), N'M')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'88888888', N'Emilia', N'Torres', N'Ayasta', CAST(N'2000-07-01' AS Date), N'F')
INSERT [dbo].[Paciente] ([DNI_Paciente], [Nombres_Paciente], [ApellidoPaterno_Paciente], [ApellidoMaterno_Paciente], [FechaNacimiento_Paciente], [Genero_Paciente]) VALUES (N'98765432', N'Luisa', N'Bustamante', N'Benavides', CAST(N'1980-09-05' AS Date), N'F')
GO
INSERT [dbo].[Personal] ([DNI_Personal], [Nombres_Personal], [ApellidoPaterno_Personal], [ApellidoMaterno_Personal], [FechaNacimiento_Personal], [Genero_Personal], [Codigo_Colegiatura], [ID_Colegio], [ID_Profesion], [ID_Establecimiento]) VALUES (N'12345678', N'admin', N'admin', N'admin', CAST(N'2000-07-26' AS Date), N'M', 83543747, 5, 5, 10001)
INSERT [dbo].[Personal] ([DNI_Personal], [Nombres_Personal], [ApellidoPaterno_Personal], [ApellidoMaterno_Personal], [FechaNacimiento_Personal], [Genero_Personal], [Codigo_Colegiatura], [ID_Colegio], [ID_Profesion], [ID_Establecimiento]) VALUES (N'34594343', N'Julian', N'Farro', N'Zapata', CAST(N'2000-05-26' AS Date), N'M', 23457343, 3, 2, 10001)
INSERT [dbo].[Personal] ([DNI_Personal], [Nombres_Personal], [ApellidoPaterno_Personal], [ApellidoMaterno_Personal], [FechaNacimiento_Personal], [Genero_Personal], [Codigo_Colegiatura], [ID_Colegio], [ID_Profesion], [ID_Establecimiento]) VALUES (N'41336364', N'Juliana', N'Zapata', N'Torres', CAST(N'1982-02-10' AS Date), N'F', 83453354, 3, 2, 10003)
INSERT [dbo].[Personal] ([DNI_Personal], [Nombres_Personal], [ApellidoPaterno_Personal], [ApellidoMaterno_Personal], [FechaNacimiento_Personal], [Genero_Personal], [Codigo_Colegiatura], [ID_Colegio], [ID_Profesion], [ID_Establecimiento]) VALUES (N'71314318', N'Jhonatan', N'Farro', N'Zapata', CAST(N'2004-07-26' AS Date), N'M', 222158234, 5, 5, 10001)
INSERT [dbo].[Personal] ([DNI_Personal], [Nombres_Personal], [ApellidoPaterno_Personal], [ApellidoMaterno_Personal], [FechaNacimiento_Personal], [Genero_Personal], [Codigo_Colegiatura], [ID_Colegio], [ID_Profesion], [ID_Establecimiento]) VALUES (N'72308372', N'Diana', N'Litano', N'Bustamante', CAST(N'2005-06-10' AS Date), N'F', 23843432, 3, 2, 10002)
GO
INSERT [dbo].[Profesion] ([ID_Profesion], [Desc_Profesion]) VALUES (1, N'MEDICO GENERAL')
INSERT [dbo].[Profesion] ([ID_Profesion], [Desc_Profesion]) VALUES (2, N'OBSTETRA')
INSERT [dbo].[Profesion] ([ID_Profesion], [Desc_Profesion]) VALUES (3, N'ENFERMERA')
INSERT [dbo].[Profesion] ([ID_Profesion], [Desc_Profesion]) VALUES (4, N'PSICOLOGO')
INSERT [dbo].[Profesion] ([ID_Profesion], [Desc_Profesion]) VALUES (5, N'INGENIERO DE SISTEMAS')
GO
SET IDENTITY_INSERT [dbo].[ReporteClinico] ON 

INSERT [dbo].[ReporteClinico] ([ID_ReporteClinico], [Nombre_ReporteClinico], [FechaRegistro_ReporteClinico], [HoraRegistro_ReporteClinico], [FechaInicio_ReporteClinico], [FechaFin_ReporteClinico], [Edad_Desde], [Edad_Hasta], [Cantidad_Examen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (1, N'Prueba establecimiento', CAST(N'2025-07-18' AS Date), CAST(N'12:42:38.5100000' AS Time), CAST(N'2025-06-01' AS Date), CAST(N'2025-07-18' AS Date), 0, 0, 6, NULL, 2, 10003)
INSERT [dbo].[ReporteClinico] ([ID_ReporteClinico], [Nombre_ReporteClinico], [FechaRegistro_ReporteClinico], [HoraRegistro_ReporteClinico], [FechaInicio_ReporteClinico], [FechaFin_ReporteClinico], [Edad_Desde], [Edad_Hasta], [Cantidad_Examen], [DNI_Personal], [ID_Atencion], [ID_Establecimiento]) VALUES (2, N'Prueba Personal', CAST(N'2025-07-18' AS Date), CAST(N'12:44:12.4700000' AS Time), CAST(N'2025-06-01' AS Date), CAST(N'2025-07-18' AS Date), 0, 0, 10, N'41336364', 2, NULL)
SET IDENTITY_INSERT [dbo].[ReporteClinico] OFF
GO
SET IDENTITY_INSERT [dbo].[Usuario] ON 

INSERT [dbo].[Usuario] ([ID_Usuario], [Correo], [Contraseña], [Rol], [DNI_Personal]) VALUES (1, N'Jhonatanfarro@gmail.com', N'9a57486ff003b2c50155934c71d1e0a74df72561fe6260f9eaefa8f6674f3d04', N'Admin', N'71314318')
INSERT [dbo].[Usuario] ([ID_Usuario], [Correo], [Contraseña], [Rol], [DNI_Personal]) VALUES (2, N'Julianazapata@gmail.com', N'b333ba110628e6213565832daf31b1ee4638aae4b9e93cb459118a1c2d4c9a38', N'Jefe de Area', N'41336364')
INSERT [dbo].[Usuario] ([ID_Usuario], [Correo], [Contraseña], [Rol], [DNI_Personal]) VALUES (4, N'Dianalitano@gmail.com', N'867ccfd6e3a27f69049f52355da5f9bf226b666220c7f013bffdff85f871201b', N'Usuario Limitado', N'72308372')
SET IDENTITY_INSERT [dbo].[Usuario] OFF
GO
ALTER TABLE [dbo].[Cita] ADD  DEFAULT ('Pendiente') FOR [Estado_Cita]
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD FOREIGN KEY([DNI_Paciente])
REFERENCES [dbo].[Paciente] ([DNI_Paciente])
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD FOREIGN KEY([DNI_Personal])
REFERENCES [dbo].[Personal] ([DNI_Personal])
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD FOREIGN KEY([ID_Atencion])
REFERENCES [dbo].[Atencion] ([ID_Atencion])
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD FOREIGN KEY([ID_Establecimiento])
REFERENCES [dbo].[Establecimiento] ([ID_Establecimiento])
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD FOREIGN KEY([ID_Usuario])
REFERENCES [dbo].[Usuario] ([ID_Usuario])
GO
ALTER TABLE [dbo].[Historial]  WITH CHECK ADD FOREIGN KEY([ID_Cita])
REFERENCES [dbo].[Cita] ([ID_Cita])
GO
ALTER TABLE [dbo].[MetaExamen]  WITH CHECK ADD FOREIGN KEY([DNI_Personal])
REFERENCES [dbo].[Personal] ([DNI_Personal])
GO
ALTER TABLE [dbo].[MetaExamen]  WITH CHECK ADD FOREIGN KEY([ID_Atencion])
REFERENCES [dbo].[Atencion] ([ID_Atencion])
GO
ALTER TABLE [dbo].[MetaExamen]  WITH CHECK ADD  CONSTRAINT [FK_MetaExamen_Establecimiento] FOREIGN KEY([ID_Establecimiento])
REFERENCES [dbo].[Establecimiento] ([ID_Establecimiento])
GO
ALTER TABLE [dbo].[MetaExamen] CHECK CONSTRAINT [FK_MetaExamen_Establecimiento]
GO
ALTER TABLE [dbo].[Personal]  WITH CHECK ADD FOREIGN KEY([ID_Colegio])
REFERENCES [dbo].[Colegio] ([ID_Colegio])
GO
ALTER TABLE [dbo].[Personal]  WITH CHECK ADD FOREIGN KEY([ID_Profesion])
REFERENCES [dbo].[Profesion] ([ID_Profesion])
GO
ALTER TABLE [dbo].[Personal]  WITH CHECK ADD  CONSTRAINT [FK_Personal_Establecimiento] FOREIGN KEY([ID_Establecimiento])
REFERENCES [dbo].[Establecimiento] ([ID_Establecimiento])
GO
ALTER TABLE [dbo].[Personal] CHECK CONSTRAINT [FK_Personal_Establecimiento]
GO
ALTER TABLE [dbo].[ReporteClinico]  WITH CHECK ADD FOREIGN KEY([ID_Atencion])
REFERENCES [dbo].[Atencion] ([ID_Atencion])
GO
ALTER TABLE [dbo].[ReporteClinico]  WITH CHECK ADD FOREIGN KEY([DNI_Personal])
REFERENCES [dbo].[Personal] ([DNI_Personal])
GO
ALTER TABLE [dbo].[ReporteClinico]  WITH CHECK ADD FOREIGN KEY([ID_Establecimiento])
REFERENCES [dbo].[Establecimiento] ([ID_Establecimiento])
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD FOREIGN KEY([DNI_Personal])
REFERENCES [dbo].[Personal] ([DNI_Personal])
GO
