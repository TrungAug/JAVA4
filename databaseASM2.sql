USE [master]
GO
/****** Object:  Database [Hankook2]    Script Date: 12/6/2023 5:35:21 PM ******/
CREATE DATABASE [Hankook2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Hankook2', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.TRUNGSSQL\MSSQL\DATA\Hankook2.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Hankook2_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.TRUNGSSQL\MSSQL\DATA\Hankook2_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Hankook2] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Hankook2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Hankook2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Hankook2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Hankook2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Hankook2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Hankook2] SET ARITHABORT OFF 
GO
ALTER DATABASE [Hankook2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Hankook2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Hankook2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Hankook2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Hankook2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Hankook2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Hankook2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Hankook2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Hankook2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Hankook2] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Hankook2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Hankook2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Hankook2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Hankook2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Hankook2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Hankook2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Hankook2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Hankook2] SET RECOVERY FULL 
GO
ALTER DATABASE [Hankook2] SET  MULTI_USER 
GO
ALTER DATABASE [Hankook2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Hankook2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Hankook2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Hankook2] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Hankook2] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Hankook2] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Hankook2', N'ON'
GO
ALTER DATABASE [Hankook2] SET QUERY_STORE = ON
GO
ALTER DATABASE [Hankook2] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Hankook2]
GO
/****** Object:  User [admin]    Script Date: 12/6/2023 5:35:22 PM ******/
CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [admin]
GO
/****** Object:  Table [dbo].[images]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[images](
	[idImg] [int] IDENTITY(1,1) NOT NULL,
	[imgSrc] [varchar](255) NULL,
	[product_id_fk_img] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idImg] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[likes]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[likes](
	[dateLike] [date] NULL,
	[idLike] [int] IDENTITY(1,1) NOT NULL,
	[product_id_fk_like] [varchar](255) NULL,
	[user_id_fk_like] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idLike] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[active] [bit] NULL,
	[buys] [int] NULL,
	[description] [varchar](255) NULL,
	[idPro] [varchar](255) NOT NULL,
	[prodName] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idPro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RelProductTyre]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RelProductTyre](
	[dateLog] [date] NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_prods] [varchar](255) NULL,
	[id_tyre] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shares]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shares](
	[dateShare] [date] NULL,
	[idShare] [int] IDENTITY(1,1) NOT NULL,
	[product_id_fk_share] [varchar](255) NULL,
	[user_id_fk_share] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idShare] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sizes]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sizes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[diameter] [varchar](255) NULL,
	[product_id_fk_size] [varchar](255) NULL,
	[profile] [varchar](255) NULL,
	[rim] [varchar](255) NULL,
	[sizeName] [varchar](255) NULL,
	[width] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tyres]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tyres](
	[idTyre] [varchar](255) NOT NULL,
	[nameTyre] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTyre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[userss]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userss](
	[admin] [bit] NOT NULL,
	[birthDay] [date] NULL,
	[email] [varchar](255) NULL,
	[fullName] [varchar](255) NULL,
	[idUs] [varchar](255) NOT NULL,
	[passWord] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[idUs] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[images]  WITH CHECK ADD  CONSTRAINT [FKmemo3xlhyqxhdr99bgud9mci9] FOREIGN KEY([product_id_fk_img])
REFERENCES [dbo].[products] ([idPro])
GO
ALTER TABLE [dbo].[images] CHECK CONSTRAINT [FKmemo3xlhyqxhdr99bgud9mci9]
GO
ALTER TABLE [dbo].[likes]  WITH CHECK ADD  CONSTRAINT [FK9wjo46a12tyl2dav9k2tsv1hf] FOREIGN KEY([product_id_fk_like])
REFERENCES [dbo].[products] ([idPro])
GO
ALTER TABLE [dbo].[likes] CHECK CONSTRAINT [FK9wjo46a12tyl2dav9k2tsv1hf]
GO
ALTER TABLE [dbo].[likes]  WITH CHECK ADD  CONSTRAINT [FKi6cc0c46x80o1iutrsobbcb9p] FOREIGN KEY([user_id_fk_like])
REFERENCES [dbo].[userss] ([idUs])
GO
ALTER TABLE [dbo].[likes] CHECK CONSTRAINT [FKi6cc0c46x80o1iutrsobbcb9p]
GO
ALTER TABLE [dbo].[RelProductTyre]  WITH CHECK ADD  CONSTRAINT [FK2801s2n5bb7o04dd3ewdh9djx] FOREIGN KEY([id_tyre])
REFERENCES [dbo].[tyres] ([idTyre])
GO
ALTER TABLE [dbo].[RelProductTyre] CHECK CONSTRAINT [FK2801s2n5bb7o04dd3ewdh9djx]
GO
ALTER TABLE [dbo].[RelProductTyre]  WITH CHECK ADD  CONSTRAINT [FKnnpokuevjnjll2736fof2lrnw] FOREIGN KEY([id_prods])
REFERENCES [dbo].[products] ([idPro])
GO
ALTER TABLE [dbo].[RelProductTyre] CHECK CONSTRAINT [FKnnpokuevjnjll2736fof2lrnw]
GO
ALTER TABLE [dbo].[shares]  WITH CHECK ADD  CONSTRAINT [FK5b0uoh53u5eash71i63b0qxd2] FOREIGN KEY([product_id_fk_share])
REFERENCES [dbo].[products] ([idPro])
GO
ALTER TABLE [dbo].[shares] CHECK CONSTRAINT [FK5b0uoh53u5eash71i63b0qxd2]
GO
ALTER TABLE [dbo].[shares]  WITH CHECK ADD  CONSTRAINT [FKe3h478mcc05n1b93novn1x7rk] FOREIGN KEY([user_id_fk_share])
REFERENCES [dbo].[userss] ([idUs])
GO
ALTER TABLE [dbo].[shares] CHECK CONSTRAINT [FKe3h478mcc05n1b93novn1x7rk]
GO
ALTER TABLE [dbo].[sizes]  WITH CHECK ADD  CONSTRAINT [FKb54ojlgewlbf1xbaifyugbm83] FOREIGN KEY([product_id_fk_size])
REFERENCES [dbo].[products] ([idPro])
GO
ALTER TABLE [dbo].[sizes] CHECK CONSTRAINT [FKb54ojlgewlbf1xbaifyugbm83]
GO
/****** Object:  StoredProcedure [dbo].[spFilterByTyre]    Script Date: 12/6/2023 5:35:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spFilterByTyre](@idTyre varchar)
As
begin
	select * from products t left join RelProductTyre tp on t.idPro=tp.id_prods
	where tp.id_tyre =@idTyre
end
GO
USE [master]
GO
ALTER DATABASE [Hankook2] SET  READ_WRITE 
GO
