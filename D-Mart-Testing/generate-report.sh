#!/bin/bash

# D-Mart Test Report Generator Script
# This script generates a comprehensive test report after test execution

echo "======================================"
echo "D-Mart Test Report Generator"
echo "======================================"
echo ""

# Get current date and time
DATE=$(date +"%Y-%m-%d")
TIME=$(date +"%H:%M:%S")
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")

# Set output directory
REPORT_DIR="test-output/ExtentReports"
TEMPLATE_FILE="TEST_REPORT_TEMPLATE.md"
OUTPUT_FILE="TEST_REPORT_${TIMESTAMP}.md"

# Create report directory if it doesn't exist
mkdir -p "$REPORT_DIR"

echo "Generating test report..."
echo "Date: $DATE"
echo "Time: $TIME"
echo ""

# Check if ExtentReports HTML exists
if [ -f "$REPORT_DIR/Report_${TIMESTAMP}.html" ]; then
    echo "✓ ExtentReports HTML report found"
else
    echo "⚠ ExtentReports HTML report not found. Run tests first."
fi

# Check if TestNG XML report exists
if [ -f "test-output/testng-results.xml" ]; then
    echo "✓ TestNG XML report found"

    # Parse TestNG results
    TOTAL=$(grep -o 'tests="[0-9]*"' test-output/testng-results.xml | head -1 | grep -o '[0-9]*')
    PASSED=$(grep -o 'passed="[0-9]*"' test-output/testng-results.xml | head -1 | grep -o '[0-9]*')
    FAILED=$(grep -o 'failed="[0-9]*"' test-output/testng-results.xml | head -1 | grep -o '[0-9]*')
    SKIPPED=$(grep -o 'skipped="[0-9]*"' test-output/testng-results.xml | head -1 | grep -o '[0-9]*')

    echo "Total Tests: $TOTAL"
    echo "Passed: $PASSED"
    echo "Failed: $FAILED"
    echo "Skipped: $SKIPPED"

    # Calculate pass rate
    if [ "$TOTAL" -gt 0 ]; then
        PASS_RATE=$((PASSED * 100 / TOTAL))
        echo "Pass Rate: ${PASS_RATE}%"
    fi
else
    echo "⚠ TestNG XML report not found. Run tests first."
    TOTAL=0
    PASSED=0
    FAILED=0
    SKIPPED=0
    PASS_RATE=0
fi

echo ""
echo "======================================"
echo "Report Generation Complete"
echo "======================================"
echo ""
echo "Generated Reports:"
echo "1. ExtentReports HTML: $REPORT_DIR/Report_${TIMESTAMP}.html"
echo "2. TestNG HTML: test-output/index.html"
echo "3. TestNG XML: test-output/testng-results.xml"
echo "4. Emailable Report: test-output/emailable-report.html"
echo ""
echo "To view the ExtentReports HTML report:"
echo "Open: $REPORT_DIR/Report_${TIMESTAMP}.html in your browser"
echo ""
