@RestController
@RequestMapping("/prescriptions")
public class PrescriptionsController {

    private final PrescriptionsService prescriptionsService;

    @Autowired
    public PrescriptionsController(PrescriptionsService prescriptionsService) {
        this.prescriptionsService = prescriptionsService;
    }

    // get all prescriptions
    @GetMapping
    public ResponseEntity<List<Prescriptions>> getAllPrescriptions() {
        List<Prescriptions> prescriptions = prescriptionsService.getAllPrescriptions();
        return ResponseEntity.ok().body(prescriptions);
    }

    // get prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<Prescriptions> getPrescriptionById(@PathVariable Long id) {
        Prescriptions prescription = prescriptionsService.getPrescriptionById(id);
        return ResponseEntity.ok().body(prescription);
    }

    //  new prescription create
    @PostMapping
    public ResponseEntity<Prescriptions> createPrescription(@RequestBody Prescriptions prescription) {
        Prescriptions createdPrescription = prescriptionsService.createPrescription(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrescription);
    }

    // update existing prescription
    @PutMapping("/{id}")
    public ResponseEntity<Prescriptions> updatePrescription(@PathVariable Long id, @RequestBody Prescriptions prescriptionDetails) {
        Prescriptions updatedPrescription = prescriptionsService.updatePrescription(id, prescriptionDetails);
        return ResponseEntity.ok().body(updatedPrescription);
    }

    // delete prescription by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrescription(@PathVariable Long id) {
        prescriptionsService.deletePrescription(id);
        return ResponseEntity.ok().build();