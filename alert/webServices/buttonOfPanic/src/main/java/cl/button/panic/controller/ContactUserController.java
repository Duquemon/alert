package cl.button.panic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.button.panic.model.Beneficiary;
import cl.button.panic.repository.BeneficiaryRepository;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/beneficiary")
public class ContactUserController {
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@PostMapping(path = "/add")
	public void addBeneficiaries(@RequestParam long idUser,@RequestParam String nameFirst, @RequestParam String nameSecond,
			@RequestParam String nameThree, @RequestParam String lastNameFirst, @RequestParam String lastNameSecond,
			@RequestParam String lastNameThree, @RequestParam String emailContactFirst,
			@RequestParam String emailContactSecond, @RequestParam String emailContactThree,
			@RequestParam String numberCellphoneContactFirst, @RequestParam String numberCellphoneContactSecond,
			@RequestParam String numberCellphoneContactThree) {
		
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setIdUser(idUser);
		beneficiary.setNameContactFirst(nameFirst);
		beneficiary.setNameContactTwo(nameSecond);
		beneficiary.setNameContactThree(nameThree);
		beneficiary.setLastNameContactFirst(lastNameFirst);
		beneficiary.setLastNameContactTwo(lastNameSecond);
		beneficiary.setLastNameContactThree(lastNameThree);
		beneficiary.setEmailContactFirst(emailContactFirst);
		beneficiary.setEmailContactTwo(emailContactSecond);
		beneficiary.setEmailContactThree(emailContactThree);
		beneficiary.setNumberCellphoneContactFirst(numberCellphoneContactFirst);
		beneficiary.setNumberCellphoneContactTwo(numberCellphoneContactSecond);
		beneficiary.setNumberCellphoneContactThree(numberCellphoneContactThree);
		beneficiaryRepository.save(beneficiary);
		}
	
	@GetMapping(path="/beneficiaries")
	public Beneficiary getBeneficiariesById(@RequestParam long idUser) {
		return beneficiaryRepository.findOne(idUser);
	}

}
