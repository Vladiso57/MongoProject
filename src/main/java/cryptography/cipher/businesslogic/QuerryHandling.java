package cryptography.cipher.businesslogic;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import datarepo.Examination;
import datarepo.IDAO;

@RestController
@RequestMapping("/api")
@Controller
public class QuerryHandling {

	@Autowired
	private IDAO handling;

	@RequestMapping("/write/{id}/{patientId}/{pulse}/{power}/{ppValue}/{meanValue}")
	public void write(@PathVariable BigDecimal id, @PathVariable BigDecimal patientId, @PathVariable long pulse, 
			@PathVariable long power, @PathVariable long ppValue, @PathVariable long meanValue) {

		handling.addRecord(id, patientId, pulse, power, ppValue, meanValue);

	}

	@RequestMapping("/read/{id}")
	public Examination read(@PathVariable BigDecimal id) {

		Examination ent = handling.showResults(id);
		if(ent != null)
			return new Examination(id, ent.getpatientId(), ent.getPulse(), ent.getPower(), ent.getPpValue(), ent.getMeanValue());
		return null;

	}

	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable BigDecimal id) {

		handling.deleteRecord(id);

	}
	
	@RequestMapping("/readAll")
	public List<Examination> readAll() {
		
		List<Examination> examinations = handling.readAllRecords();
		return examinations;
		
	}

	@RequestMapping("/readByPatientId/{patientId}")
	public List<Examination> readAllRecordsGivenPatientId(@PathVariable BigDecimal patientId) {

		System.out.println("Jestem");
		List<Examination> ents = handling.readAllRecordsGivenPatientId(patientId);
		return ents;

	}

}
