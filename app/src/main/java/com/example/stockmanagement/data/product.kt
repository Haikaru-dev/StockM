import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(

    @PrimaryKey(autoGenerate = true)
    val productId: Int = 0,          // auto ID

    val name: String,
    val category: String,
    val supplier: String,
    val price: Double,
    val quantity: Int,

    val qrCode: String,              // store QR value
    val updatedAt: Long              // System.currentTimeMillis()
)