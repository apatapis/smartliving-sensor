package di.smartliving.sensor.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import di.smartliving.sensor.service.MqttService;
import di.smartliving.sensor.web.rest.resource.RepeatMessageRequest;
import di.smartliving.sensor.web.rest.resource.SendMessageRequest;

@RestController
@RequestMapping(path = "api/sensor")
public class SensorController {

	@Autowired
	private MqttService mqttService;

	@PostMapping(path = "/message/send")
	@ResponseStatus(HttpStatus.OK)
	public void sendMessage(@RequestBody SendMessageRequest sendMessageRequest) {
		System.out.println(sendMessageRequest);
		mqttService.sendMessage(sendMessageRequest);
	}

	@PostMapping(path = "/message/repeat")
	@ResponseStatus(HttpStatus.OK)
	public String repeatMessage(@RequestBody RepeatMessageRequest repeatMessageRequest) {
		System.out.println(repeatMessageRequest);
		return mqttService.repeatMessage(repeatMessageRequest);
	}

	@PutMapping(path = "/message/{clientId}/stop")
	@ResponseStatus(HttpStatus.OK)
	public void stopMessage(@PathVariable(name = "clientId") String clientId) {
		mqttService.stopMessage(clientId);
	}

}