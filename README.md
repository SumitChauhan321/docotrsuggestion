# docotrsuggestion


////Add doctor/////////
@PostMapping("add")
	public ResponseEntity<DoctorEntity> addDoctor(@Valid @RequestBody DoctorEntity doctor)
	{
		System.out.println("Controller called");
		doctorService.addDoctor(doctor);	
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}



 ///////Add patient///////////////
  @PostMapping("add")
	public ResponseEntity<PatientEntity> addPatient(@Valid @RequestBody PatientEntity patient)
	{
		patientService.addPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}


 ////////////////////////Doctor list////////////
 @GetMapping("doctor-list")
   public ResponseEntity<List<DoctorEntity>> getDoctorList(@RequestParam int pid)
   {
	   List<DoctorEntity> doctorList=patientService.getList(pid);
	   return ResponseEntity.ok(doctorList);
   }


   ///////////////////doctorlist Service code////////////
   public List<DoctorEntity> getList(int pid)
	{
		PatientEntity patient=patientRepository.findById(pid).orElseThrow(()-> new PatientNotFound("Patient with id" +pid+"does not exist"));
		String city=patient.getCity();
        if(!city.equals("Noida") && !city.equals("Delhi")&&!city.equals("Faridabad"))
        	throw new RuntimeException("we are still waiting to expand your location");
        String symptom=patient.getSymptom();
        String speciality=SymptomSpeciality.map.get(symptom);
        List<DoctorEntity> doctorList=doctorRepository.getDoctorList(city,speciality);
        if(doctorList.isEmpty())
        	throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
		return doctorList;
	}
