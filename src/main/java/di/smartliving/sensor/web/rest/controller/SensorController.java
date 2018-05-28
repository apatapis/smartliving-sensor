package di.smartliving.sensor.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import di.smartliving.sensor.service.MqttService;
import di.smartliving.sensor.web.rest.resource.SendMessageOnceRequest;

@Controller
@RequestMapping(path = "api/sensor")
public class SensorController {

	@Autowired
	private MqttService mqttService;

	@PostMapping(path = "/message")
	@ResponseStatus(HttpStatus.OK)
	public void sendMessageOnce(@RequestBody SendMessageOnceRequest sendMessageOnceRequest) {
		System.out.println(sendMessageOnceRequest);
		mqttService.sendMessage(sendMessageOnceRequest);
	}

}