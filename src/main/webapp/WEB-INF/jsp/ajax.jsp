<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="ajax" />
    </jsp:include>

    <h2>Ajax Example</h2>
    <input type="radio" id="html" name="fav_language" value="1">
    <label for="html">1</label><br>
    <input type="radio" id="css" name="fav_language" value="2">
    <label for="css">2</label><br>
    <input type="radio" id="javascript" name="fav_language" value="3">
    <label for="javascript">3</label>

    <script>
        $(document).ready(
            function () {
                $('input[type=radio]').change(function () {
                    console.log(this.value);

                    $.ajax({
                        url: "/ajaxcall",
                        data: {
                            clickedValue: this.value
                        },
                        success: function (result) {
                            // console.log("server responded : " + result);
                            console.log(result.primaryColor);
                        },
                        error: function (data) {
                            console.log("Ajax call failed");
                        }
                    });
                });
            }
        );
    </script>

    <jsp:include page="include/footer.jsp" />