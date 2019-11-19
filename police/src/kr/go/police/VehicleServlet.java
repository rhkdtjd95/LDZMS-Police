package kr.go.police;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;

@WebServlet("/service/vehicle")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = -8905486472611696968L;

	private static Map<String, Vehicle> repository = new HashMap<String, Vehicle>();

	static {
		repository.put("12가3356", new Vehicle("12가3356", "Ray", 998));
        repository.put("39라5478", new Vehicle("39가5478", "Morning", 999));
        repository.put("28가6761", new Vehicle("28가6761", "Damas", 796));
        repository.put("33나4752", new Vehicle("33나4752", "Porter", 2497));
        repository.put("47파0913", new Vehicle("47파0913", "Genesis G80", 3342));
        repository.put("77마7777", new Vehicle("77마7777", "Malibu", 1490));
        repository.put("52마5252", new Vehicle("52마5252", "Sorrento", 1995));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

		String accessKey = request.getParameter("accessKey");
		String no = request.getParameter("no");

		String msg = "";
		if (accessKey != null && no != null) {
			msg = getMessage(no);
		} else {
			msg = getMessage(new Message("500", "요청 값이 잘못되었습니다."));
		}


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");

		response.getWriter().write(msg);
	}

	private String getMessage(String no) {
		Map<String, Object> result = new HashMap<String, Object>();

		Vehicle vehicle = this.repository.get(no);
		if (vehicle != null) {
			result.put("message", new Message("200", ""));
			result.put("vehicle", vehicle);
		} else {
			result.put("message", new Message("600", "요청 정보를 찾을 수 없습니다."));
			result.put("vehicle", new Vehicle());
		}

		return toJSON(result);
	}

	private String getMessage(Message message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("message", message);
		result.put("vehicle", new Vehicle());

		return toJSON(result);
	}

	private String toJSON(Map<String, Object> object) {
		return new GsonBuilder()
		        .setPrettyPrinting()
		        .serializeNulls()
		        .create().toJson(object); 
	}
}
