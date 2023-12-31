<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="sliderCarouse" class="carousel slide mb-3"
	data-bs-ride="carousel">
	<div class="carousel-indicators">
		<button type="button" data-bs-target="#sliderCarouse"
			data-bs-slide-to="0" class="active" aria-current="true"
			aria-label="Slide 1"></button>
		<button type="button" data-bs-target="#sliderCarouse"
			data-bs-slide-to="1" aria-label="Slide 2"></button>
		<button type="button" data-bs-target="#sliderCarouse"
			data-bs-slide-to="2" aria-label="Slide 3"></button>
	</div>
	<div class="carousel-inner">
		<div class="carousel-item active" data-bs-interval="3000">
			<video class="img-fluid" autoplay loop muted>
				<source
					src="https://asset.hankooktire.com/content/dam/hankooktire/global/video/main/LC_uk_en_iON_2_1920_970_1209.mp4"
					type="video/mp4" />
			</video>
		</div>
		<div class="carousel-item" data-bs-interval="3000">
			<video class="img-fluid" autoplay loop muted>
				<source
					src="https://asset.hankooktire.com/content/dam/hankooktire/global/video/main/LC_febrandfilm_1920_970_230418.mp4"
					type="video/mp4" />
			</video>
		</div>
		<div class="carousel-item" data-bs-interval="3000">
			<video class="img-fluid" autoplay loop muted>
				<source
					src="https://asset.hankooktire.com/content/dam/hankooktire/global/video/main/LC_kinergy_1920_970_230523.mp4"
					type="video/mp4" />
			</video>
		</div>
	</div>
	<button class="carousel-control-prev" type="button"
		data-bs-target="#sliderCarouse" data-bs-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Previous</span>
	</button>
	<button class="carousel-control-next" type="button"
		data-bs-target="#sliderCarouse" data-bs-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Next</span>
	</button>
</div>
