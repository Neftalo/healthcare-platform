@RestController
@RequestMapping("/lab-orders")
public class LabOrdersController {

    private final LabOrdersService labOrdersService;

    @Autowired
    public LabOrdersController(LabOrdersService labOrdersService) {
        this.labOrdersService = labOrdersService;
    }

    // Endpoint to get all lab orders
    @GetMapping
    public ResponseEntity<List<LabOrders>> getAllLabOrders() {
        List<LabOrders> labOrders = labOrdersService.getAllLabOrders();
        return ResponseEntity.ok().body(labOrders);
    }

    // get a lab order by ID
    @GetMapping("/{id}")
    public ResponseEntity<LabOrders> getLabOrderById(@PathVariable Long id) {
        LabOrders labOrder = labOrdersService.getLabOrderById(id);
        return ResponseEntity.ok().body(labOrder);
    }

    // new lab order
    @PostMapping
    public ResponseEntity<LabOrders> createLabOrder(@RequestBody LabOrders labOrder) {
        LabOrders createdLabOrder = labOrdersService.createLabOrder(labOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLabOrder);
    }

    // update existing lab order
    @PutMapping("/{id}")
    public ResponseEntity<LabOrders> updateLabOrder(@PathVariable Long id, @RequestBody LabOrders labOrderDetails) {
        LabOrders updatedLabOrder = labOrdersService.updateLabOrder(id, labOrderDetails);
        return ResponseEntity.ok().body(updatedLabOrder);
    }

    //delete a lab order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLabOrder(@PathVariable Long id) {
        labOrdersService.deleteLabOrder(id);
        return ResponseEntity.ok().build();
    }
}