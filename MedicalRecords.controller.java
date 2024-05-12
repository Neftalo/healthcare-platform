public class MedicalRecordsController {

    private final DiagnosisService diagnosisService;
    private final HealthHistoryService healthHistoryService;

    @Autowired
    public MedicalRecordsController(DiagnosisService diagnosisService, HealthHistoryService healthHistoryService) {
        this.diagnosisService = diagnosisService;
        this.healthHistoryService = healthHistoryService;
    }

    // Endpoints for Diagnosis

    @GetMapping("/diagnoses")
    public ResponseEntity<List<Diagnosis>> getAllDiagnoses() {
        List<Diagnosis> diagnoses = diagnosisService.getAllDiagnoses();
        return ResponseEntity.ok().body(diagnoses);
    }

    @GetMapping("/diagnoses/{id}")
    public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable Long id) {
        Diagnosis diagnosis = diagnosisService.getDiagnosisById(id);
        return ResponseEntity.ok().body(diagnosis);
    }

    @PostMapping("/diagnoses")
    public ResponseEntity<Diagnosis> createDiagnosis(@RequestBody Diagnosis diagnosis) {
        Diagnosis createdDiagnosis = diagnosisService.createDiagnosis(diagnosis);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiagnosis);
    }

    @PutMapping("/diagnoses/{id}")
    public ResponseEntity<Diagnosis> updateDiagnosis(@PathVariable Long id, @RequestBody Diagnosis diagnosisDetails) {
        Diagnosis updatedDiagnosis = diagnosisService.updateDiagnosis(id, diagnosisDetails);
        return ResponseEntity.ok().body(updatedDiagnosis);
    }

    @DeleteMapping("/diagnoses/{id}")
    public ResponseEntity<?> deleteDiagnosis(@PathVariable Long id) {
        diagnosisService.deleteDiagnosis(id);
        return ResponseEntity.ok().build();
    }

    // Endpoints for Health History

    @GetMapping("/health-history")
    public ResponseEntity<List<HealthHistory>> getAllHealthHistories() {
        List<HealthHistory> healthHistories = healthHistoryService.getAllHealthHistories();
        return ResponseEntity.ok().body(healthHistories);
    }

    @GetMapping("/health-history/{id}")
    public ResponseEntity<HealthHistory> getHealthHistoryById(@PathVariable Long id) {
        HealthHistory healthHistory = healthHistoryService.getHealthHistoryById(id);
        return ResponseEntity.ok().body(healthHistory);
    }

    @PostMapping("/health-history")
    public ResponseEntity<HealthHistory> createHealthHistory(@RequestBody HealthHistory healthHistory) {
        HealthHistory createdHealthHistory = healthHistoryService.createHealthHistory(healthHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthHistory);
    }

    @PutMapping("/health-history/{id}")
    public ResponseEntity<HealthHistory> updateHealthHistory(@PathVariable Long id, @RequestBody HealthHistory healthHistoryDetails) {
        HealthHistory updatedHealthHistory = healthHistoryService.updateHealthHistory(id, healthHistoryDetails);
        return ResponseEntity.ok().body(updatedHealthHistory);
    }

    @DeleteMapping("/health-history/{id}")
    public ResponseEntity<?> deleteHealthHistory(@PathVariable Long id) {
        healthHistoryService.deleteHealthHistory(id);
        return ResponseEntity.ok().build();
    }
}