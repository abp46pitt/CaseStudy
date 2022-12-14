<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="index" />
    </jsp:include>

    <div class="container" id="container">
        <div class="row my-5">
            <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="../../pub/images/Black_TiRex.jpg" class="d-block w-50 mx-auto" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="../../pub/images/blue_screamer.jpg" class="d-block w-50 mx-auto" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="../../pub/images/green_screamer.jpg" class="d-block w-50 mx-auto" alt="...">
                    </div>
                </div>
            </div>
        </div>
        <div class="row my-5">
            <div class="col-lg-6 my-4">
                <h2 class="text-center">What is a recumbent bike?</h2>
                <p>A recumbent bike is a bike that puts the rider in a laid-back position with a nice seat to sit on to
                    boot! Recumbent bikes are very comfortable for longer rides and allow for greater power output to
                    the
                    pedals despite the laid-back position. Here at Recumbent Bike Rentals, we love Rans recumbent bikes
                    so
                    we specialize in renting them out.</p>
            </div>
            <div class="col-lg-6 my-4">
                <h2 class="text-center">Who are we?</h2>
                <p>We here at Recumbent Bike Rentals are a group of biking enthusiasts who want to share the joy of
                    recumbent biking with the world! Before starting Recumbent Bike Rentals we noticed a huge interest
                    in these bikes while out on rides so we created a rental service to share the experience with
                    others.</p>
            </div>
        </div>
    </div>

    <jsp:include page="include/footer.jsp" />